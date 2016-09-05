/*Following the unnecessary 'notes'*/
import java.util.Scanner;
import java.io.FileReader;
class GradeArray {
static public void main(String[]args) throws Exception {
int numGrade[]=new int[15]; //int array for student number grade
char letterGrade[]=new char[15]; //char array for student letter grade
int numLetters[]=new int[5];
int avg=0;
Scanner input=new Scanner(new FileReader("grade.txt"));
for (int i=0;i<15;i++) {
numGrade[i]=input.nextInt(); //iterate through text file
avg+=numGrade[i];
if (numGrade[i]<60) letterGrade[i]='F'; //translate to letter grade
else if (numGrade[i]<70) letterGrade[i]='D';
else if (numGrade[i]<80) letterGrade[i]='C';
else if (numGrade[i]<90) letterGrade[i]='B';
else letterGrade[i]='A'; 
}
for (int i=0;i<15;i++) { //count number of each letter
switch (letterGrade[i]) {
case 'A':numLetters[0]++; break;
case 'B':numLetters[1]++; break;
case 'C':numLetters[2]++; break;
case 'D':numLetters[3]++; break;
default: numLetters[4]++;
}
}
//print number and letter grade for each student? I think that's what the second-last note means
for (int i=0;i<15;i++) System.out.printf("%4d,",numGrade[i]);
System.out.println();
for (int i=0;i<15;i++) System.out.printf("%4s,",letterGrade[i]);
//marks
System.out.printf("\nThe average grade of these 15 students is: %.2f\n",avg/(double)15);
System.out.printf("There are %d students that got A\n",numLetters[0]);
System.out.printf("There are %d students that got B\n",numLetters[1]);
System.out.printf("There are %d students that got C\n",numLetters[2]);
System.out.printf("There are %d students that got D\n",numLetters[3]);
System.out.printf("There are %d students that got F\n",numLetters[4]);
} 
}