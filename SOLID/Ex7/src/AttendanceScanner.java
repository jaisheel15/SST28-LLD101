public class AttendanceScanner implements SmartClassroomDevice , PowerInterface , AttendanceInterface {
    @Override public void powerOn() { /* ok */ }
    @Override public void powerOff() { /* no output */ }

    @Override public int scanAttendance() { return 3; }
}
