package foody02.project.myapplication.helper;

public class Consts {

    private static final String HOST_DOMAIN = "";
    private static final String HOST_DEV = "";
    private static final String LOCALHOST = "";

    public static final String HOST_API = HOST_DEV;

    public static final String REST_ENDPOINT = "api/";
    public static final String HEADES = "Authorization:Basic YWRtaW46cXRjdGVrQDEyMwx==";
    public static final int REQUEST_CODE_AUTOCOMPLETE = 222;
    public static final int REQUEST_CODE_GPS = 120;

    private static final String MODE_PRODUCTION = "production";
    private static final String MODE_DEBUG = "debug";
    public static final boolean TRUST_CERTIFICATE = false;


    public static final String MODE = MODE_DEBUG;

    public static final String TAG_FRAGMENT_CHECK = "FragmentCheck";

    public static final int LOCATION_INTERVAL = 10000;
    public static final int FASTEST_LOCATION_INTERVAL = 5000;
}
