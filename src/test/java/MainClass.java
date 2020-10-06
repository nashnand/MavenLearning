import org.testng.annotations.Test;

public class MainClass {
    @Test
    public static void master() {
        Rest_01_GetRequest Getreq = new Rest_01_GetRequest();
        Getreq.Getrequest();
        Rest_02_Post Postreq = new Rest_02_Post();
        Postreq.postrequest();
        Rest_03_Put Putreq = new Rest_03_Put();
        Putreq.putrequest();
        Rest_04_GetRequestParticular GetReqParticular = new Rest_04_GetRequestParticular();
        GetReqParticular.getemployeedetails();

    }
}
