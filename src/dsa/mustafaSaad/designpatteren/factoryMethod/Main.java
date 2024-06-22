package dsa.mustafaSaad.designpatteren.factoryMethod;


//Scenario: Document Management System

/**
 * Imagine you are developing a document management system where you need to create different types of documents
 * such as Word documents, PDF documents, and Text documents. Depending on the user's choice,
 * the system should create the appropriate document type.
 * <p>
 * The Factory Method pattern is beneficial here because it allows you to define an interface for creating documents
 * while letting the subclasses decide which specific document type to instantiate. This makes the system extensible and easy
 * to manage.
 */

//1. Product Interface:
interface Document {
    void open();

    void save();
}

// 2. Concrete Products:
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document.");
    }

    public void save() {
        System.out.println("Saving Word document.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document.");
    }

    public void save() {
        System.out.println("Saving PDF document.");
    }
}

class TextDocument implements Document {
    public void open() {
        System.out.println("Opening Text document.");
    }

    public void save() {
        System.out.println("Saving Text document.");
    }
}

//3. Creator (Factory):
abstract class DocumentCreator {
    public abstract Document createDocument();

    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }

    public void saveDocument() {
        Document doc = createDocument();
        doc.save();
    }
}

//4. Concrete Creators:
class WordDocumentCreator extends DocumentCreator {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentCreator extends DocumentCreator {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class TextDocumentCreator extends DocumentCreator {
    public Document createDocument() {
        return new TextDocument();
    }
}

//5. Client Code:
public class Main {
    public static void main(String[] args) {
        DocumentCreator creator;

        creator = new WordDocumentCreator();
        creator.openDocument(); // Output: Opening Word document.
        creator.saveDocument(); // Output: Saving Word document.

        creator = new PdfDocumentCreator();
        creator.openDocument(); // Output: Opening PDF document.
        creator.saveDocument(); // Output: Saving PDF document.

        creator = new TextDocumentCreator();
        creator.openDocument(); // Output: Opening Text document.
        creator.saveDocument(); // Output: Saving Text document.
    }
}


