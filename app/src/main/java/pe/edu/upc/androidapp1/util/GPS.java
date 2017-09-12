package pe.edu.upc.androidapp1.util;


import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class GPS {
    public static Location currentBestLocation;
    private static LocationManager b;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;

    public static int TEN_SECONDS = 10000;
    public static String mensaje;

    private static LocationResult f;

    static LocationListener a = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {
            Log.d("Location", "Location Received: " + location.getLatitude()
                    + "; " + location.getLongitude());
            try {
                if (GPS.isBetterLocation(location, GPS.currentBestLocation)) {
                    GPS.currentBestLocation = location;
                }

            } catch (Exception localException) {
                Log.e("Location", "onLocationChanged", localException);
            }
        }
    };

    public static boolean isCanGetLocation() {
        return e;
    }

    public static void setCanGetLocation(boolean paramBoolean) {
        e = paramBoolean;
    }

    public static void setLocationResult(LocationResult paramLocationResult) {
        f = paramLocationResult;
    }

    public static boolean startListening(Context paramContext) {
        if (b == null)
            b = (LocationManager) paramContext.getSystemService(Context.LOCATION_SERVICE);
        System.out.println(b.getAllProviders().toString());
        try {
            c = b.isProviderEnabled("gps");
        } catch (Exception localException1) {
        }
        try {
            d = b.isProviderEnabled("network");
        } catch (Exception localException2) {
        }
        if ((!c) && (!d)) {
            setCanGetLocation(false);
            return false;
        }
        if (c) {
            setCanGetLocation(true);
            b.requestLocationUpdates("gps", TEN_SECONDS, 10.0F, a);
            System.out.println("GPS Registered");
            mensaje = "GPS";
        }

        if (d) {
            setCanGetLocation(true);
            b.requestLocationUpdates("network", TEN_SECONDS, 10.0F, a);
            System.out.println("Network Registered");
            mensaje = "Network";
        }

        return true;
    }

    public static boolean startListening(Context paramContext,
                                         LocationResult paramLocationResult) {
        setLocationResult(paramLocationResult);
        return startListening(paramContext);
    }

    public static Location getLocation() throws Exception {
        if (currentBestLocation == null) {
            Location localLocation1 = b.getLastKnownLocation("gps");
            Location localLocation2 = b.getLastKnownLocation("network");
            if ((c & d)) {
                if (isBetterLocation(localLocation1, localLocation2)) {
                    currentBestLocation = localLocation1;
                    mensaje = "GPS";
                } else {
                    currentBestLocation = localLocation2;
                    mensaje = "Network";
                }
            } else if (c) {
                mensaje = "GPS";
                currentBestLocation = localLocation1;
            } else if (d) {
                mensaje = "Network";
                currentBestLocation = localLocation2;
            }
        }
        return currentBestLocation;
    }

    public static String getMensaje() {
        return mensaje;
    }

    public static void stopListening() {
        try {
            b.removeUpdates(a);
            f = null;
        } catch (NullPointerException localNullPointerException) {
        }
    }

    public static String getLocationState() {
        StringBuilder localStringBuilder = new StringBuilder("network: ");
        if (d)
            localStringBuilder.append("ON");
        else {
            localStringBuilder.append("OFF");
        }
        localStringBuilder.append("\ngps: ");
        if (c)
            localStringBuilder.append("ON");
        else {
            localStringBuilder.append("OFF");
        }
        return localStringBuilder.toString();
    }

    protected static boolean isBetterLocation(Location paramLocation1,
                                              Location paramLocation2) throws Exception {
        if (paramLocation2 == null) {
            return true;
        }

        long l = paramLocation1.getTime() - paramLocation2.getTime();
        int i = l > 120000L ? 1 : 0;
        int j = l < -120000L ? 1 : 0;
        int k = l > 0L ? 1 : 0;

        if (i != 0) {
            return true;
        }

        if (j != 0) {
            return false;
        }

        int m = (int) (paramLocation1.getAccuracy() - paramLocation2
                .getAccuracy());
        int n = m > 0 ? 1 : 0;
        int i1 = m < 0 ? 1 : 0;
        int i2 = m > 200 ? 1 : 0;

        boolean bool = a(paramLocation1.getProvider(),
                paramLocation2.getProvider());

        if (i1 != 0)
            return true;
        if ((k != 0) && (n == 0)) {
            return true;
        }

        return (k != 0) && (i2 == 0) && (bool);
    }

    private static boolean a(String paramString1, String paramString2) {
        if (paramString1 == null) {
            return paramString2 == null;
        }
        return paramString1.equals(paramString2);
    }

    public static abstract class LocationResult {
        public abstract void getLocation(Location paramLocation);
    }

}
