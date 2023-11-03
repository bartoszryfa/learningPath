public class Main {
    public static void main(String[] args) {
        displayInformationAboutCandidate("Martin", 29, "Java", "Spring boot", "SQL", "Hibernate");
    }

    private static void displayInformationAboutCandidate(String name, int age, String... skills) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
        System.out.println("Skills: ");

        for(String skill : skills) {
            System.out.println(skill);
        }
    }
}