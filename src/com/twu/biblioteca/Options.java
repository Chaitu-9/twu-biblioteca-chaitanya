package com.twu.biblioteca;


//Display options for user
public class Options {
    Library library;
    private BibliotecaView bibliotecaView;
    private Librarian librarian;
    private Login login;
    private User user;
    private CheckoutRegister checkoutRegister;

    public Options(Library library, BibliotecaView bibliotecaView, Librarian librarian, Login login, User user, CheckoutRegister checkoutRegister) {
        this.library = library;
        this.bibliotecaView = bibliotecaView;
        this.librarian = librarian;
        this.login = login;
        this.user = user;
        this.checkoutRegister = checkoutRegister;
    }

    public void start(){
        welcome();
        displayOptions();
    }
    public void welcome(){
        System.out.print(Messages.WELCOME_MESSAGE);
    }

    public void displayOptions(){
        System.out.print("\n1. " + Messages.LIST_BOOKS + "\n" +
                "2. " + Messages.CHECKOUT_BOOK +"\n" +
                "3. " + Messages.RETURN_BOOK +"\n"+
                "4. " + Messages.LIST_MOVIES +"\n"+
                "5. " + Messages.CHECKOUT_MOVIE +"\n"+
                "6. " + Messages.RETURN_MOVIE +"\n"+
                "7. " + Messages.USER_DETAILS +"\n"+
                "8. " + Messages.CHECKOUT_HISTORY +"\n"+
                "9. " + Messages.EXIT + "\n");
    }

    public void selectOption(){
        int option;
        String name, userId, password;

        do {
            bibliotecaView.display(Messages.ENTER_OPTION);
            option = bibliotecaView.getIntegerInput();
            switch (option) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    bibliotecaView.getStringInput();
                    bibliotecaView.display(Messages.USERID_AND_PASSWORD);
                    userId = bibliotecaView.getStringInput();
                    password = bibliotecaView.getStringInput();
                    if(login.validate(userId, password)) {
                        bibliotecaView.display(Messages.SUCCESSFUL_LOGIN);
                        bibliotecaView.display(Messages.BOOK_NAME);
                        name = bibliotecaView.getStringInput();
                        checkoutRegister.checkedOutDetails(userId, name);
                        librarian.checkOutBook(name);
                    }else
                    bibliotecaView.display(Messages.INVALID_USERID_OR_PASSWORD);
                    break;
                case 3:
                    bibliotecaView.getStringInput();
                    bibliotecaView.display(Messages.USERID_AND_PASSWORD);
                    userId = bibliotecaView.getStringInput();
                    password = bibliotecaView.getStringInput();
                    if(login.validate(userId, password)) {
                        bibliotecaView.display(Messages.SUCCESSFUL_LOGIN);
                        bibliotecaView.display(Messages.BOOK_NAME);
                        name = bibliotecaView.getStringInput();
                        if (checkoutRegister.validateReturn(userId, name)) {
                            librarian.returnBook(name);
                            checkoutRegister.removeBook(userId, name);
                        } else
                            bibliotecaView.display(Messages.UNSUCCESSFUL_RETURN_BOOK);
                    }else
                        bibliotecaView.display(Messages.INVALID_USERID_OR_PASSWORD);
                    break;
                case 4:
                    library.displayAvailableMovies();
                    break;
                case 5:
                    bibliotecaView.getStringInput();
                    bibliotecaView.display(Messages.USERID_AND_PASSWORD);
                    userId = bibliotecaView.getStringInput();
                    password = bibliotecaView.getStringInput();
                    if(login.validate(userId, password)) {
                        bibliotecaView.display(Messages.SUCCESSFUL_LOGIN);
                        bibliotecaView.display(Messages.MOVIE_NAME);
                        name = bibliotecaView.getStringInput();
                        librarian.checkOutMovie(name);
                    }else
                        bibliotecaView.display(Messages.INVALID_USERID_OR_PASSWORD);
                    break;
                case 6:
                    bibliotecaView.getStringInput();
                    bibliotecaView.display(Messages.USERID_AND_PASSWORD);
                    userId = bibliotecaView.getStringInput();
                    password = bibliotecaView.getStringInput();
                    if(login.validate(userId, password)) {
                        bibliotecaView.display(Messages.SUCCESSFUL_LOGIN);
                        bibliotecaView.display(Messages.MOVIE_NAME);
                        name = bibliotecaView.getStringInput();
                        if (checkoutRegister.validateReturn(userId, name)) {
                            librarian.returnMovie(name);
                            checkoutRegister.removeBook(userId, name);
                            }
                        else
                            bibliotecaView.display(Messages.UNSUCCESSFUL_RETURN_BOOK);
                    }else
                        bibliotecaView.display(Messages.INVALID_USERID_OR_PASSWORD);
                    break;
                case 7:
                    bibliotecaView.getStringInput();
                    bibliotecaView.display(Messages.USERID_AND_PASSWORD);
                    userId = bibliotecaView.getStringInput();
                    password = bibliotecaView.getStringInput();
                    if(login.validate(userId, password)) {
                        bibliotecaView.display(Messages.SUCCESSFUL_LOGIN);
                        bibliotecaView.display(login.currentUserDetails());
                    }
                    else
                        bibliotecaView.display(Messages.INVALID_USERID_OR_PASSWORD);
                    break;
                case 8:
                    bibliotecaView.getStringInput();
                    bibliotecaView.display(Messages.USERID_AND_PASSWORD);
                    userId = bibliotecaView.getStringInput();
                    password = bibliotecaView.getStringInput();
                    if(login.validate(userId, password) && userId.equals("admin")) {
                        bibliotecaView.display(Messages.SUCCESSFUL_LOGIN);
                        bibliotecaView.display(checkoutRegister.toString());
                    }
                    else {
                        bibliotecaView.display(Messages.INVALID_USERID_OR_PASSWORD);
                    }
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid Option. Enter again : ");
                    break;
            }
        }while (option != -1);
    }
}