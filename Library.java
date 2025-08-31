import java.util.Scanner;
import java.util.Arrays;
public class Library{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        Books b=new Books();
        User u=new User();
        int size=10;
        //list of all books
        Books[] book=new Books[size];
        for(int i=0;i<book.length;i++)
        {
                book[i]=new Books();
        }
        b.availableBooks(book);

        //list of regular users
        User[] userArr=new User[size];
        for(int i=0;i<userArr.length;i++)
        {
                userArr[i]=new User();
        }
        u.regularUsers(userArr);

        byte choice;   //byte-->occupies less memory space
        String name;
        long contact; 

        do{
        System.out.println("I am : \n1. Librarian \n2. User \n3. Exit");
        System.out.print("Enter your choice: ");
        choice=sc.nextByte();
        
//-----------------------main switch case--------------------------
        switch(choice)
        {   //-----------------LIBRARIAN-----------------------
            case 1: byte choice1;
                    do
                    {
                    System.out.println("-----------------------------------------");
                    System.out.println("1. Display all books \n2. Add book \n3. Search book \n4. Display user's information \n5. Issue book \n6. Update book \n7. Exit");
                    System.out.print("Enter your choice: ");
                    choice1=sc.nextByte();

                    switch(choice1)
                    {
                        case 1: for(int i=0;i<book.length;i++)
                                {
                                    book[i].displayBooks(book);
                                }
                                break;
                        case 2: b.add(book);
                                break;
                        case 3: //search book
                                System.out.println("1. Search book by name. \n2. Search books by author's name. \n3. Search books by genre.  ");
                                System.out.print("Enter your choice: ");
                                byte choice5=sc.nextByte();
                                switch(choice5){
                                case 1: System.out.print("Enter name of the book you want to search: ");
                                        sc.nextLine();
                                        String nameBook=sc.nextLine();
                                        boolean found=false;
                                        for(int i=0;i<book.length;i++)
                                        {
                                                found=book[i].searchByName(nameBook);
                                                if(found)
                                                {
                                                        break;
                                                }
                                        }
                                        if(!found)
                                        {
                                                System.out.println("This book is unavailable.");
                                                break;
                                        }
                                        break;
                                case 2: System.out.print("Enter name of the author you want to search: ");
                                        sc.nextLine();
                                        String nameAuthor=sc.nextLine();
                                        boolean found1=false;
                                        for(int i=0;i<book.length;i++)
                                        {
                                                found1=book[i].searchByAuthor(nameAuthor,book);
                                                if(found1)
                                                {
                                                       break;
                                                }
                                        }
                                        if(!found1)
                                        {
                                                System.out.println("This author's book is unavailable.");
                                                break;
                                        }
                                        break;
                                case 3: System.out.print("Enter name of the genre you want to search: ");
                                        sc.nextLine();
                                        String nameGenre=sc.nextLine();
                                        boolean found2=false;
                                        for(int i=0;i<book.length;i++)
                                        {
                                                found2=book[i].searchByGenre(nameGenre,book);
                                                if(found2)
                                                {
                                                        break;
                                                }
                                                
                                        }
                                        if(!found2)
                                        {
                                                System.out.println("This genre is unavailable."+b.bookId);
                                                break;
                                        }
                                        break;
                                default:System.out.println("Please choose from 1,2 or 3.");
                                        break;
                                }
                                break;
                        case 4: for(int i=0;i<userArr.length;i++)
                                {
                                        userArr[i].displayUser(userArr);
                                }
                                break;
                        case 5: b.issue(userArr,book);
                                break;
                        case 6: b.update(book);
                        case 7: System.out.println("Thank you.");
                                break;
                        default:System.out.println("Please select from 1 to 7.");
                                break;
                    }
                }while(choice1!=7);
                    break;
            //--------------------USER-----------------------
            case 2: System.out.println("-----------------------------");
                    System.out.println("1. New user \n2. Regular user");
                    System.out.println("Enter your choice: ");
                    byte choice2=sc.nextByte();
                    switch(choice2)
                    {   
                        //---------------NEW USER------------------
                        case 1: byte choice3;
                                
                                System.out.print("Enter your name: ");
                                name=sc.nextLine();
                                name=sc.nextLine();
                                boolean test=true;
                                do
                                {
                                        System.out.println("Enter 5 digit phone number: ");
                                        contact=sc.nextLong();
                                        if(contact<100000 && contact>9999)
                                        {
                                                test=false;
                                        }
                                        else
                                        {
                                                System.out.println("Please enter 5 digit number only.");
                                        }
                                        
                                }while(test);
                                u.addNewUserToArray(userArr, name, contact);
                                
                                do{
                                System.out.println("---------------------");
                                System.out.println("1. Display available books \n2. Search book \n3. Exit");
                                System.out.print("Please enter your choice: ");
                                choice3=sc.nextByte();
                                
                                switch(choice3)
                                {
                                    case 1: for(int i=0;i<book.length;i++)
                                            {
                                                book[i].displayBooks(book);
                                            }
                                            break;
                                    case 2: //search book
                                                System.out.println("1. Search book by name. \n2. Search books by author's name. \n3. Search books by genre.  ");
                                                System.out.print("Enter your choice: ");
                                                byte choice5=sc.nextByte();
                                                switch(choice5){
                                                        case 1: System.out.print("Enter name of the book you want to search: ");
                                                                sc.nextLine();
                                                                String nameBook=sc.nextLine();
                                                                boolean found=false;
                                                                for(int i=0;i<book.length;i++)
                                                                {
                                                                        found=book[i].searchByName(nameBook);
                                                                        if(found)
                                                                        {
                                                                                break;
                                                                        }
                                                                }
                                                                if(!found)
                                                                {
                                                                        System.out.println("This book is unavailable.");
                                                                        break;
                                                                }
                                                                break;
                                                        case 2: System.out.print("Enter name of the author you want to search: ");
                                                                sc.nextLine();
                                                                String nameAuthor=sc.nextLine();
                                                                boolean found1=false;
                                                                for(int i=0;i<book.length;i++)
                                                                {
                                                                        found1=book[i].searchByAuthor(nameAuthor,book);
                                                                        if(found1)
                                                                        {
                                                                                break;
                                                                        }
                                                                }
                                                                if(!found1)
                                                                {
                                                                        System.out.println("This author's book is unavailable.");
                                                                        break;
                                                                }
                                                                break;
                                                        case 3: System.out.print("Enter name of the genre you want to search: ");
                                                                sc.nextLine();
                                                                String nameGenre=sc.nextLine();
                                                                boolean found2=false;
                                                                for(int i=0;i<book.length;i++)
                                                                {
                                                                        found2=book[i].searchByGenre(nameGenre,book);
                                                                        if(found2)
                                                                        {
                                                                                break;
                                                                        }
                                                                }
                                                                if(!found2)
                                                                {
                                                                        System.out.println("This genre is unavailable.");
                                                                        break;
                                                                }
                                                                break;
                                                        default:System.out.println("Please choose from 1,2 or 3.");
                                                                break;
                                                }
                                            break;
                                    case 3: System.out.println("Thank you.");
                                            break;    
                                    default:System.out.println("Please enter your choice between 1 to 3 only.");
                                            break;
                                }
                        }while(choice3!=3);
                                break;
                        //-----------------REGULAR USER------------------
                        case 2: byte choice4;
                                System.out.print("Enter your name: ");
                                String nameUser=sc.nextLine();
                                nameUser=sc.nextLine();
                                boolean foundUser=false;
                                for(int i=0;i<userArr.length;i++)
                                { 
                                        foundUser=userArr[i].searchUser(nameUser);
                                        if(foundUser)
                                        {
                                                break;
                                        }
                                }
                                if(!foundUser)
                                {
                                        System.out.println("Sorry, user not found.");
                                        break;
                                } 
                                
                                do{
                                System.out.println("---------------------");
                                System.out.println("1. Display available books \n2. Search book \n3. Return book \n4. Exit");
                                System.out.print("Please enter your choice: ");
                                choice4=sc.nextByte();

                                switch(choice4)
                                {
                                    case 1: for(int i=0;i<book.length;i++)
                                            {
                                                book[i].displayBooks(book);
                                            }
                                            break;
                                    case 2: //search book
                                            System.out.println("1. Search book by name. \n2. Search books by author's name. \n3. Search books by genre.  ");
                                            System.out.print("Enter your choice: ");
                                            byte choice5=sc.nextByte(); 
                                            switch(choice5){
                                                case 1: System.out.print("Enter name of the book you want to search: ");
                                                        sc.nextLine();
                                                        String nameBook=sc.nextLine();
                                                        boolean found=false;
                                                        for(int i=0;i<book.length;i++)
                                                        {
                                                                found=book[i].searchByName(nameBook);
                                                                if(found)
                                                                {
                                                                        break;
                                                                }
                                                        }
                                                        if(!found)
                                                        {
                                                                System.out.println("This book is unavailable.");
                                                                break;
                                                        }
                                                        break;
                                                case 2: System.out.print("Enter name of the author you want to search: ");
                                                        sc.nextLine();
                                                        String nameAuthor=sc.nextLine();
                                                        boolean found1=false;
                                                        for(int i=0;i<book.length;i++)
                                                        {
                                                                found1=book[i].searchByAuthor(nameAuthor,book);
                                                                if(found1)
                                                                {
                                                                        break;

                                                                }
                                                        }
                                                        if(!found1)
                                                        {
                                                                System.out.println("This author's book is unavailable.");
                                                                break;
                                                        }
                                                        break;
                                                case 3: System.out.print("Enter name of the genre you want to search: ");
                                                        sc.nextLine();
                                                        String nameGenre=sc.nextLine();
                                                        boolean found2=false;
                                                        for(int i=0;i<book.length;i++)
                                                        {
                                                                found2=book[i].searchByGenre(nameGenre,book);
                                                                if(found2)
                                                                {
                                                                        break;
                                                                }
                                                        }
                                                         if(!found2)
                                                        {
                                                                System.out.println("This genre is unavailable.");
                                                                break;
                                                        }
                                                        break;
                                                default:System.out.println("Please choose from 1,2 or 3.");
                                                        break;
                                            }
                                            break;
                                    case 3: b.returnBook(userArr,book,nameUser);
                                            break;
                                    case 4: System.out.println("Thank you.");
                                            break;
                                    default:System.out.println("Please enter your choice between 1 to 4 only.");
                                            break;
                                }
                                }while(choice4!=4);
                                break;
                        default:System.out.println("Please enter either 1 or 2.");
                                break;
                    }
                
                    break;
            case 3: System.out.println("Thank you.");
                    break;
            default:System.out.println("Please enter either 1,2 or 3");
                    break;
        }
        }while(choice!=3);
        sc.close();
    }
}
class Books
{
        static
        {
                System.out.println("=================================================================================");
                System.out.println("===================  WELCOME TO LIBRARY MANAGEMENT SYSTEM  ======================");
                System.out.println("=================================================================================");
        }
        Scanner scn=new Scanner(System.in);

        String bookName,bookAuthor,bookGenre;
        String newBookName,newBookAuthor,newBookGenre;
        int bookId,bookNotIssued,booksIssued;
        int newBookId,newBookQuantity;
        boolean checkAdd;
        
        void availableBooks(Books[] book)
        {
        book[0].bookId=1;
	book[0].bookName="Sherlock Holmes";
	book[0].bookGenre="Mystery";
	book[0].bookAuthor="Arthur Conan Doyle";
        book[0].bookNotIssued=10;
        book[0].booksIssued=0;

        book[1].bookId=2;
	book[1].bookName="The Underground Railroad";
	book[1].bookGenre="Fiction";
	book[1].bookAuthor="Colson Whitehead";
        book[1].bookNotIssued=10;
        book[1].booksIssued=0;

	book[2].bookId=3;
	book[2].bookName="City of Spells";
	book[2].bookGenre="Fantasy";
	book[2].bookAuthor="Alexandra Christo";
        book[2].bookNotIssued=10;
        book[2].booksIssued=0;

	book[3].bookId=4;
	book[3].bookName="Harlem Shuffle";
	book[3].bookGenre="Mystery";
	book[3].bookAuthor="Colson Whitehead";
        book[3].bookNotIssued=10;
        book[3].booksIssued=0;

	book[4].bookId=5;
	book[4].bookName="The Queen of Nothing";
	book[4].bookGenre="Fantasy";
	book[4].bookAuthor="Holly Black";
	book[4].bookNotIssued=10;
        book[4].booksIssued=0;

	book[5].bookId=6;
	book[5].bookName="Shivaji: The Great Maratha";
	book[5].bookGenre="History";
	book[5].bookAuthor="Ranjit Desai";
	book[5].bookNotIssued=10;
        book[5].booksIssued=0;

	book[6].bookId=7;
	book[6].bookName="In Into the Crooked Place";
	book[6].bookGenre="Mystery";
	book[6].bookAuthor="Alexandra Christo";
        book[6].bookNotIssued=10;
        book[6].booksIssued=0;

       
        book[7].bookId=8;
        book[8].bookId=9;
        book[9].bookId=10;
        }
        void displayBooks(Books[] book)  
        {
                if(bookName!=null)
                {
                        System.out.println();
                        System.out.println("Name of the book: "+bookName);
                        System.out.println("Book genre: "+bookGenre);
                        System.out.println("Author: "+bookAuthor);
                        System.out.println("Number of books available for issuing: "+bookNotIssued);
                }
        }
        void showDetails()
        {
                System.out.println();
                System.out.println("Name of the book: "+bookName);
                System.out.println("Book genre: "+bookGenre);
                System.out.println("Author: "+bookAuthor);
                System.out.println("Number of books available for issuing: "+bookNotIssued);
                
        }
        void add(Books[] book) {
                    
                        System.out.print("Enter the name of the new book: ");
                        newBookName = scn.nextLine();
                    
                        System.out.print("Enter the author of the new book: ");
                        newBookAuthor = scn.nextLine();
                    
                        System.out.print("Enter the genre of the new book: ");
                        newBookGenre = scn.nextLine();
                    
                        System.out.print("Enter the quantity of the new book: ");
                        newBookQuantity = scn.nextInt();

                        newBookId = generateUniqueBookId(book);
                        addNewBookToArray(book);
                    
                        checkAdd = true;
        }
        int generateUniqueBookId(Books[] book) {
                        int maxId = 0;
                    
                        for (Books existingBook : book) {
                            if (existingBook != null && existingBook.bookId > maxId) {
                                maxId = existingBook.bookId;
                            }
                        }
                        System.out.println(maxId);
                        return maxId + 1;
                        
        }
        void addNewBookToArray(Books[] book) {
                        int index = -1;
                        for (int i = 0; i < book.length; i++) { 
                            if (book[i].bookName == null) {
                                index = i;
                                break;
                            }
                        }
                    
                        if (index != -1) {
                            book[index] = new Books();
                            book[index].bookId = newBookId;
                            book[index].bookName = newBookName;
                            book[index].bookAuthor = newBookAuthor;
                            book[index].bookGenre = newBookGenre;
                            book[index].bookNotIssued = newBookQuantity;
                    
                            System.out.println("New book added successfully!");
                        } else {
                            System.out.println("The library is at full capacity. Unable to add a new book.");
                        }
        }
        
        boolean searchByName(String nameBook)
        {
                // The name of every book is unique
                if(nameBook.equalsIgnoreCase(bookName))
                {
                        showDetails();
                        return(true);
                }
                else
                {
                        return(false);
                }
        }
        boolean searchByAuthor(String nameAuthor,Books[] book)
        {
               //More than one book can have same genre
               boolean found = false;
                        
               for (Books currentBook : book) 
               {
                       if(currentBook.bookAuthor!=null){ //without this condition null pointer exception will be thrown
                               if (currentBook.bookAuthor.equalsIgnoreCase(nameAuthor)) 
                               {
                                       currentBook.showDetails();
                                       found = true;
                               }
                       }
                       else
                       {
                               break;
                       }
               }
                   
               if (!found) {
                       System.out.println("Books of this author are unavailable.");
               }
               return found;
               
        }
        boolean searchByGenre(String nameGenre,Books[] book)
        {
                //As more than one book can have same genre
                boolean found = false;
                        
                for (Books currentBook : book) 
                {
                        if(currentBook.bookGenre!=null)
                        { 
                                //without this condition null pointer exception will be thrown
                                if (currentBook.bookGenre.equalsIgnoreCase(nameGenre)) {
                                        currentBook.showDetails();
                                        found = true;
                                }
                        }
                        else
                        {
                                break;
                        }
                }
                    
                if (!found) {
                        System.out.println("Books of this genre are unavailable.");
                }
                return found;
                    
        }
        void update(Books[] book)
        {
                System.out.print("Enter the name of the book you want to update: ");
                String bookToUpdate = scn.nextLine();
                    
                boolean found = false;
                    
                for (int i = 0; i < book.length; i++) {
                        if (book[i].bookName.equalsIgnoreCase(bookToUpdate)) 
                        {
                                System.out.println("Enter updated details for the book:");
                    
                                System.out.print("New name: ");
                                book[i].bookName = scn.nextLine();
                    
                                System.out.print("New author: ");
                                book[i].bookAuthor = scn.nextLine();
                    
                                System.out.print("New genre: ");
                                book[i].bookGenre = scn.nextLine();
                    
                                System.out.print("New quantity available: ");
                                book[i].bookNotIssued = scn.nextInt();
                    
                                System.out.println("Book details updated successfully.");
                                found = true;
                                break;
                        }
                }
                    
                if (!found) {
                        System.out.println("Book not found. Update failed.");
                }    
        }
        void issue(User[] userArr, Books[] book) {
            
                System.out.print("Enter user name: ");
                String userName = scn.nextLine();
            
                // Check if the user exists
                boolean userFound = false;
                int userIndex = -1;
                for (int i = 0; i < userArr.length; i++) {
                    if (userName.equalsIgnoreCase(userArr[i].name)) {
                        userFound = true;
                        userIndex = i;
                        break;
                    }
                }
            
                if (!userFound) {
                    System.out.println("User not found. Cannot issue a book.");
                    return;
                }
            
                System.out.print("Enter the name of the book to be issued: ");
                String bookName = scn.nextLine();
            
                // Check if the book exists
                boolean bookFound = false;
                int bookIndex = -1;
                for (int i = 0; i < book.length; i++) {
                    if (bookName.equalsIgnoreCase(book[i].bookName)) {
                        bookFound = true;
                        bookIndex = i;
                        break;
                    }
                }
            
                if (!bookFound) {
                    System.out.println("Book not found.");
                    return;
                }
            
                // Check if the book is available for issuing
                if (book[bookIndex].bookNotIssued <= 0) {
                    System.out.println("Not available for issuing.");
                    return;
                }
            
                // Issue the book
                book[bookIndex].bookNotIssued--;
                System.out.println("Book issued successfully to " + userArr[userIndex].name);
            
                 userArr[userIndex].booksIssued++;
            }
        void returnBook(User[] userArr, Books[] book, String userName)
        {
                // Check if the user exists
                boolean userFound = false;
                int userIndex = -1;
                for (int i = 0; i < userArr.length; i++) 
                {
                        if (userName.equalsIgnoreCase(userArr[i].name))
                        {
                                userFound = true;
                                userIndex = i;
                                break;
                        }
                }
                    
                if (!userFound)
                {
                        System.out.println("User not found");
                        return;
                }
                    
                System.out.print("Enter the name of the book to be returned: ");
                String bookName = scn.nextLine();
                    
                // Check if the book exists
                boolean bookFound = false;
                int bookIndex = -1;
                for (int i = 0; i < book.length; i++)
                {
                        if (bookName.equalsIgnoreCase(book[i].bookName)) 
                        {
                                bookFound = true;
                                bookIndex = i;
                                break;
                        }
                }
                    
                if (!bookFound) 
                {
                        System.out.println("Book not found. Cannot return the book.");
                        return;
                }
                
                book[bookIndex].bookNotIssued++;
                System.out.println("Book returned successfully by " + userArr[userIndex].name);
                    
                if (userArr[userIndex].booksIssued > 0)
                {
                        userArr[userIndex].booksIssued--;
                } else {
                            System.out.println("This user did not have any books issued.");
                        }
                    
        }
}
class RegularUsers{
        Scanner scanner=new Scanner(System.in);
        String name;
        long phone;
        int booksIssued;
        boolean userAdded;
        void regularUsers(User[] user)
        {
                user[0].name="Jetshree Sharma";
                user[0].phone=12345;
                user[0].booksIssued=0;
                
                user[1].name="Sanket Mehta";
                user[1].phone=11111;
                user[1].booksIssued=0;
                
                user[2].name="Ashutosh Chudasama";
                user[2].phone=22222;
                user[2].booksIssued=0;
                
                user[3].name="Prachi";
                user[3].phone=33333; 
                user[3].booksIssued=0;

                user[4].name="Poojan";
                user[4].phone=44444;
                user[4].booksIssued=0;

                user[5].name="Nandini";
                user[5].phone=55555;
                user[5].booksIssued=0;

                user[6].name="Meet";
                user[6].phone=66666;
                user[6].booksIssued=0;
        }
}
class User extends RegularUsers
{
        void displayUser(User[] userArr)
        {
                if(name!=null)
                {
                        System.out.println();
                        System.out.println("Name: "+name);
                        System.out.println("Contact number: "+phone);
                        System.out.println("No. of books issued: "+booksIssued);
                }
        }
        boolean searchUser(String nameUser)
        {
                if(nameUser.equalsIgnoreCase(name))
                {
                        return(true);
                }
                else
                {
                        return(false);
                }
        }
        void addNewUserToArray(User[] userArr,String newUserName,long contact)
        {
                // Find the first available slot in the userArr array
                userAdded=true;
                int index = -1;
                for (int i = 0; i < userArr.length; i++) { 
                    if (userArr[i].name == null) {
                        index = i;
                        break;
                    }
                }
            
                // If an available slot is found, add the new user
                if (index != -1)
                {
                    userArr[index] = new User();
                    userArr[index].name = newUserName;
                    userArr[index].phone = contact;
                    userArr[index].booksIssued = 0;
                    
                } 
                else 
                {
                    System.out.println("Sorry, unable to login.");
                }
        }
}
    