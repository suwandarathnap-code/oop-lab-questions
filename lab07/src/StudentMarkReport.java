public class StudentMarkReport {

    private String[] marks;

    public StudentMarkReport(String[] marks) {
        this.marks = marks;
    }

    public int getMarkAt(int index) {

        // ArrayIndexOutOfBoundsException occurs
        // if the selected index does not exist.

        // NumberFormatException occurs
        // if the selected value is not a valid number.

        String mark = marks[index];
        return Integer.parseInt(mark);

    }

}