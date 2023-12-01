package pl.bartoszryfa.crudProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;
    @GetMapping("")
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }
    @GetMapping("/{id}")
    public Movie getById(@PathVariable("id") int id) {
        return movieRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Movie> movies) {
        return movieRepository.save(movies);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movieById = movieRepository.getById(id);

        if(movieById != null) {
            movieById.setName(updatedMovie.getName());
            movieById.setRaiting(updatedMovie.getRaiting());

            movieRepository.update(movieById);
            return 1;
        } else {
            return -1;
        }
    }
    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movieById = movieRepository.getById(id);

        if(movieById != null) {

           if(updatedMovie.getName() != null) movieById.setName(updatedMovie.getName());
           if(updatedMovie.getRaiting() > 0) movieById.setRaiting((updatedMovie.getRaiting()));

            movieRepository.update(movieById);
            return 1;
           } else {
                return -1;
        }
    }
    @DeleteMapping("/{id}")
    public int deleteRecord(@PathVariable("id") int id) {
        return movieRepository.delete(id);
    }

    // Dodaj obsługę wyjątków dla RuntimeException
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleRuntimeException(RuntimeException e) {
        return "Wystąpił błąd: " + e.getMessage();
    }

}
