# FileCompare

Zip and return all source files.
In the first exercise you will implement a simple service to calculate Tribonnaci numbers. The
service will be called by multiple clients simultaneously.
1) Tribonnaci
Implement the following Java interface:
import java.math.BigInteger;
public interface TribonnaciService {
/**
* Calculates tribonnaci numbers recursively
* @param n
* @return The nth tribonnaci number
*/
public BigInteger getTribonnaciRecursive(int n);
/**
* Calculates tribonnaci numbers iteratively
* @param n
* @return The nth tribonnaci number
*/
public BigInteger getTribonnaciIterative(int n);
}


2) Testing

Write a test class for your TribonnaciService implementation. You may use a unit test framework
of your choice.


3) Data Comparison
A database stores the details of employees in a table as follows:
ID NAME AGE JOB_TITLE START_DATE
1 Simon 28 Designer 2010-04-11
2 Mary 32 Developer 2011-06-15
3 Chris 31 Developer 2012-11-06
4 Stuart 45 Designer 2012-02-02
5 Jane 41 Project Manager 2010-07-19
6 Emma 38 Designer 2010-03-04
7 Julia 38 Developer 2011-12-11
8 Sam 32 Marketing 2013-01-04
9 Pam 39 Operations 2013-02-16
10 Simon 24 Operations 2012-09-02
11 Bob 26 Business Analyst 2012-02-02
12 Frank 22 Business Analyst 2010-11-30
The id field is the primary key on this table. Now imagine that the data in this table is sent out in a
variety of formats, CSV / XML / Pipe separated etc.
Without using any external libraries, write a program to compare a comma separated and a pipe
separated version of the file. The program should take the two file names as command line
arguments.


4) Testing
Write unit tests for the program you have created above.



Please find the source code in the attachment.
I have included both my initial train of thought python code and the finished TDD coded java. 
On the first exercise I assumed the initial Tribonacci trio was 0, 0, 1, but changing that should not impact the overall functionality
The second one uses the unit test resource files to test the implementation. The task was rather vague in that it said compare the two files, so I just 
read 1 csv file vs 1 pipe file, and tested scenarious where the files were the same and different.
I have tried naming the methods and classes as clearly as I could to make the could readable and require as little comments as possible.

Coverage is 100% on both projects. 
I used TestNG for the multithreaded testing capabilities, as well as the nl.jqno.equalsverifier.EqualsVerifier
to test that the equals and hash methods have been correctly overridden/implemented.
I would have parameterized the test for the first Exercise but that would not be as readable and would not show my TDD approach.
Also the second test class in that exercise is there to simulate calls from different clients.

