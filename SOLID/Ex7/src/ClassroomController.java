public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        SmartClassroomDevice pj = reg.getFirstOfType("Projector");
        
        ((PowerInterface) pj).powerOn();
        ((InputControllerInterface) pj).connectInput("HDMI-1");

        SmartClassroomDevice lights = reg.getFirstOfType("LightsPanel");
        ((BrightnessInterface) lights).setBrightness(60);

        SmartClassroomDevice ac = reg.getFirstOfType("AirConditioner");
        ((TemperatureControllerInterface) ac)   .setTemperatureC(24);

        SmartClassroomDevice scan = reg.getFirstOfType("AttendanceScanner");
    System.out.println("Attendance scanned: present=" + ((AttendanceInterface) scan).scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        ((PowerInterface) reg.getFirstOfType("Projector")).powerOff();
        ((PowerInterface) reg.getFirstOfType("LightsPanel")).powerOff();
        ((PowerInterface) reg.getFirstOfType("AirConditioner")).powerOff();
    }
}
