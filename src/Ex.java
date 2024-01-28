import java.util.*;
import java.util.stream.Collectors;

public class Ex {
    // Òåã
    public static class Tag {
        String name;

        public Tag(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Êíèãà
    public static class Book {
        String name;
        List<Tag> tags;

        public Book(String name, List<Tag> tags) {
            this.name = name;
            this.tags = tags;
        }

    }

    // Àâòîð
    public static class Author {
        String id;
        String name;
        List<Book> books;

        public Author(String id, String name, List<Book> books) {
            this.id = id;
            this.name = name;
            this.books = books;
        }

    }

    /**
     * Âîçâðàùàåò ñïèñîê òåãîâ êíèã àâòîðîâ, óêàçàííûõ ñïèñêîì èäåíòèôèêàòîðîâ
     *
     * @param authors         ñïèñîê àâòîðîâ
     * @param searchAuthorIds ñïèñîê èäåíòèôèêàòîðîâ àâòîðîâ, òåãè êíèã êîòîðûõ íåîáõîäèìî ïîëó÷èòü
     * @return ñïèñîê òåãîâ êíèã óêàçàííûõ àâòîðîâ
     */
    public static List<Tag> getTagsOfAuthorsBooks(List<Author> authors, List<String> searchAuthorIds) {
        List<Tag> tags = new ArrayList<>();


        //return authors.stream().filter(n -> searchAuthorIds.contains(n.id)).flatMap(author -> author.books.stream()).flatMap(b -> b.tags.stream()).collect(Collectors.toList());

        for (Author author : authors) {
            if (searchAuthorIds.contains(author.id)) {
                for (Book book : author.books) {
                    tags.addAll(book.tags);
                }
            }
        }
        return tags;
    }

    public static void main(String[] args) throws MyException {
        Tag tag1 = new Tag("Tag_1");
        Tag tag2 = new Tag("Tag_2");
        Tag tag3 = new Tag("Tag_3");
        Tag tag4 = new Tag("Tag_4");
        Tag tag5 = new Tag("Tag_5");
        Tag tag6 = new Tag("Tag_6");
        Tag tag7 = new Tag("Tag_7");

        Book book1 = new Book("Book_1", List.of(tag1));
        Book book2 = new Book("Book_2", List.of(tag2, tag3));
        Book book3 = new Book("Book_3", List.of(tag4, tag5));
        Book book4 = new Book("Book_4", List.of(tag6, tag7));

        Author author1 = new Author("Author_1", "Ivanov", List.of(book1, book2));
        Author author2 = new Author("Author_2", "Petrov", List.of(book3));
        Author author3 = new Author("Author_3", "Sidorov", List.of(book4));

        List<Author> allAuthors = List.of(author1, author2, author3);
        List<Tag> allTags = List.of(tag1, tag2, tag3, tag4, tag5, tag6, tag7);

        List<String> searchAuthorIds = List.of("Author_1", "Author_3");

        List<Tag> tags = getTagsOfAuthorsBooks(allAuthors, searchAuthorIds);

        System.out.println(tags);
    }

    public static void filterTripleA(Collection strings) {
        strings.removeIf(element -> element.toString().startsWith("aaa"));
    }

    public static double foo(double[] sourceArray) throws MyException {
        if (sourceArray == null) throw new MyException("Массив не инициализирован !");
        if (sourceArray.length == 2) throw new MyException("!!!");


        double min = Arrays.stream(sourceArray).min().getAsDouble();
        double max = Arrays.stream(sourceArray).max().getAsDouble();
        double sum = Arrays.stream(sourceArray).sum() / 2;

        return (max - min) / sum;
    }

    public static int[] sort(int[] sourceArray) throws MyException {
        if (sourceArray == null) throw new MyException("Массив не инициализирован !");
        if (sourceArray.length == 1) return sourceArray;

        int value;
        for (int i = 0; i < sourceArray.length - 1; i++) {
            for (int j = i + 1; j < sourceArray.length; j++) {
                if (sourceArray[j] > sourceArray[i]) {
                    value = sourceArray[i];
                    sourceArray[i] = sourceArray[j];
                    sourceArray[j] = value;
                }
            }
        }
        return sourceArray;
    }
}

class Person {
    String firstName;
    String lastName;
    Integer age;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;

        return firstName.equals(person.firstName) && lastName.equals(person.lastName) && age.equals(person.age);
    }
}

/**
 * select c.name , a.description , avg(f.amount) avg_amount
 * from Customer c left join Account a on c.id = a.customer_id
 * left join Fin_Transaction f on a.id = f.account_id
 * group by c.name , a.description
 *
 */