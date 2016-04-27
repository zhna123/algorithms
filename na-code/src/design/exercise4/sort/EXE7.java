package design.exercise4.sort;

/**
 * 4-7. [3] Outline a reasonable method of solving each of the following problems. Give
 * the order of the worst-case complexity of your methods.
 * 
 * (a) You are given a pile of thousands of telephone bills and thousands of checks
 * sent in to pay the bills. Find out who did not pay.
 * 
 * sort, then match -> nlogn + n < 2nlogn (cost nlogn)
 * 
 * (b) You are given a list containing the title, author, call number and publisher of
 * all the books in a school library and another list of 30 publishers. Find out
 * how many of the books in the library were published by each company.
 * 
 * sort by publisher. then match -> nlogn + n
 * or use a hashtable to store publisher and book numbers. cost O(n)
 * 
 * (c) You are given all the book checkout cards used in the campus library during
 * the past year, each of which contains the name of the person who took out
 * the book. Determine how many distinct people checked out at least one book.
 * 
 * 
 * sort the name, then count --> nlogn + n
 * or use a hashtable to store name and number of books
 * 
 * @author nz026920
 * 
 */
public class EXE7 {

}
