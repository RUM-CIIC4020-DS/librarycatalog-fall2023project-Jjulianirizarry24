#Library Project



##Features

Read Books and users from a csv file
Add books to catalog
Remove books from catalog
Return a book
Check if a book is checked out
Count number of books by Title
Count number of books by Genre
Calculate how much a user owes for each book
Generate a report for the current book catalog and calculate information such as
amount of books of a given genre, total books in the catalog, the amount each
user owes and the total amount due taking into consideration all of the users. 

##Main Classes:

Book: Saves information of books in catalog
User: Saves information of people that can take books
LibraryCatalog: Stores information of books and users read from a csv file 
LibraryGUI: Implements a user interface for the user to view current books
in catalog, and add/remove books.



##Main methods:

addBook(title, author, genre): Add a book to catalog
removeBook(id): Remove a book
checkOutBook(id): Check out book
returnBook(id): Return book
getBookAvailability(id): Check if a book is available
bookCount(title): Count books with same title
genreCount(genre): Count books with same genre
generateReport(): Generate a report summarizing catalog information
Implemented methods to filter books and users



