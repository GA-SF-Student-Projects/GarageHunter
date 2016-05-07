//<<<<<<< HEAD
////package com.example.nicolassaad.garagehunter;
////
////import android.Manifest;
////import android.content.IntentSender;
////import android.content.pm.PackageManager;
////import android.location.Location;
////import android.os.Bundle;
////import android.support.v4.app.ActivityCompat;
////import android.support.v4.app.FragmentActivity;
////import android.util.Log;
////
////import com.google.android.gms.common.ConnectionResult;
////import com.google.android.gms.common.api.GoogleApiClient;
////import com.google.android.gms.location.LocationListener;
////import com.google.android.gms.location.LocationRequest;
////import com.google.android.gms.location.LocationServices;
////import com.google.android.gms.maps.CameraUpdateFactory;
////import com.google.android.gms.maps.GoogleMap;
////import com.google.android.gms.maps.SupportMapFragment;
////import com.google.android.gms.maps.model.LatLng;
////import com.google.android.gms.maps.model.MarkerOptions;
////
////public class MapsActivity extends FragmentActivity implements
////        GoogleApiClient.ConnectionCallbacks,
////        GoogleApiClient.OnConnectionFailedListener,
////        LocationListener {
////
////    public static final String TAG = MapsActivity.class.getSimpleName();
////    /*
////    * Define a request code to send to Google Play services
////    * This code is returned in Activity.onActivityResult
////    */
////    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
////    private LocationRequest mLocationRequest;
////    private GoogleMap mMap;
////    private GoogleApiClient mGoogleApiClient;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_maps);
////        Log.d("MainActivity", "Setting up Bowl Sheet");
////        setUpMapIfNeeded();
////
//////        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//////                .findFragmentById(R.id.map);
//////        mapFragment.getMapAsync(this);
////
////        mGoogleApiClient = new GoogleApiClient.Builder(this)
////                .addConnectionCallbacks(this)
////                .addOnConnectionFailedListener(this)
////                .addApi(LocationServices.API)
////                .build();
////
////        // Create the LocationRequest object
////        mLocationRequest = LocationRequest.create()
////                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
////                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
////                .setFastestInterval(1 * 1000); // 1 second, in milliseconds
////
////    }
////
////    @Override
////    protected void onResume() {
////        super.onResume();
////        setUpMapIfNeeded();
////        mGoogleApiClient.connect();
////    }
////
////    @Override
////    protected void onPause() {
////        super.onPause();
////
////        if (mGoogleApiClient.isConnected()) {
////            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
////            mGoogleApiClient.disconnect();
////        }
////    }
////
////    /**
////     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
////     * installed) and the map has not already been instantiated.. This will ensure that we only ever
////     * call {@link #setUpMap()} once when {@link #mMap} is not null.
////     * <p/>
////     * If it isn't installed {@link SupportMapFragment} (and
////     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
////     * install/update the Google Play services APK on their device.
////     * <p/>
////     * A user can return to this FragmentActivity after following the prompt and correctly
////     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
////     * have been completely destroyed during this process (it is likely that it would only be
////     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
////     * method in {@link #onResume()} to guarantee that it will be called.
////     */
////    private void setUpMapIfNeeded() {
////        // Do a null check to confirm that we have not already instantiated the map.
////        if (mMap == null) {
////            Log.d("MainActivity", "Setting up Bowl Sheet");
////            // Try to obtain the map from the SupportMapFragment.
////            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
////                    .getMap();
////            // Check if we were successful in obtaining the map.
////            if (mMap != null) {
////                setUpMap();
////            }
////        }
////    }
////
////    /**
////     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
////     * just add a marker near Africa.
////     * <p/>
////     * This should only be called once and when we are sure that {@link #mMap} is not null.
////     */
////    private void setUpMap() {
////        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
////    }
////
////    private void handleNewLocation(Location location) {
////        Log.d(TAG, location.toString());
////        Log.d("MainActivity", "Handling new Bowl Sheet");
////
////        double currentLatitude = location.getLatitude();
////        double currentLongitude = location.getLongitude();
////
////        LatLng latLng = new LatLng(currentLatitude, currentLongitude);
////
////        mMap.addMarker(new MarkerOptions().position(new LatLng(currentLatitude, currentLongitude)).title("Current Location"));
////        MarkerOptions options = new MarkerOptions()
////                .position(latLng)
////                .title("I am here!");
////        mMap.addMarker(options);
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
////    }
////
////    @Override
////    public void onConnected(Bundle bundle) {
////        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
////            // TODO: Consider calling
////            Log.d("MainActivity", "Bowl Sheet");
////            //    ActivityCompat#requestPermissions
////            // here to request the missing permissions, and then overriding
////            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
////            //                                          int[] grantResults)
////            // to handle the case where the user grants the permission. See the documentation
////            // for ActivityCompat#requestPermissions for more details.
//////            return;
////        }
////        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
////        if (location == null) {
////            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
////        }
////        else {
////            handleNewLocation(location);
////        }
////    }
////
////    @Override
////    public void onConnectionSuspended(int i) {
////
////    }
////
////    @Override
////    public void onConnectionFailed(ConnectionResult connectionResult) {
////        /*
////         * Google Play services can resolve some errors it detects.
////         * If the error has a resolution, try sending an Intent to
////         * start a Google Play services activity that can resolve
////         * error.
////         */
////        if (connectionResult.hasResolution()) {
////            try {
////                // Start an Activity that tries to resolve the error
////                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
////                /*
////                 * Thrown if Google Play services canceled the original
////                 * PendingIntent
////                 */
////            } catch (IntentSender.SendIntentException e) {
////                // Log the error
////                e.printStackTrace();
////            }
////        } else {
////            /*
////             * If no resolution is available, display a dialog to the
////             * user with the error.
////             */
////            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
////        }
////    }
////
////    @Override
////    public void onLocationChanged(Location location) {
////        handleNewLocation(location);
////    }
////
////
//////    @Override
//////    public void onMapReady(GoogleMap googleMap) {
//////        mMap = googleMap;
//////
//////        // Add a marker in Sydney, Australia, and move the camera.
//////        LatLng sf = new LatLng(37.77, 122.41);
//////        mMap.addMarker(new MarkerOptions().position(sf).title("Marker in SF"));
//////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sf));
//////    }
////
////}
//=======
//package com.example.nicolassaad.garagehunter;
//
//import android.Manifest;
//import android.content.IntentSender;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.os.Bundle;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.app.FragmentActivity;
//import android.util.Log;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.location.LocationListener;
//import com.google.android.gms.location.LocationRequest;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//public class MapsActivity extends FragmentActivity implements
//        GoogleApiClient.ConnectionCallbacks,
//        GoogleApiClient.OnConnectionFailedListener,
//        LocationListener {
//
//    public static final String TAG = MapsActivity.class.getSimpleName();
//    /*
//    * Define a request code to send to Google Play services
//    * This code is returned in Activity.onActivityResult
//    */
//    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
//    private LocationRequest mLocationRequest;
//    private GoogleMap mMap;
//    private GoogleApiClient mGoogleApiClient;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        Log.d("MainActivity", "Setting up Bowl Sheet");
//        setUpMapIfNeeded();
//
////        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
////                .findFragmentById(R.id.map);
////        mapFragment.getMapAsync(this);
//
//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi(LocationServices.API)
//                .build();
//
//        // Create the LocationRequest object
//        mLocationRequest = LocationRequest.create()
//                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
//                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
//                .setFastestInterval(1 * 1000); // 1 second, in milliseconds
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        setUpMapIfNeeded();
//        mGoogleApiClient.connect();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        if (mGoogleApiClient.isConnected()) {
//            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
//            mGoogleApiClient.disconnect();
//        }
//    }
//
//    /**
//     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
//     * installed) and the map has not already been instantiated.. This will ensure that we only ever
//     * call {@link #setUpMap()} once when {@link #mMap} is not null.
//     * <p/>
//     * If it isn't installed {@link SupportMapFragment} (and
//     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
//     * install/update the Google Play services APK on their device.
//     * <p/>
//     * A user can return to this FragmentActivity after following the prompt and correctly
//     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
//     * have been completely destroyed during this process (it is likely that it would only be
//     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
//     * method in {@link #onResume()} to guarantee that it will be called.
//     */
//    private void setUpMapIfNeeded() {
//        // Do a null check to confirm that we have not already instantiated the map.
//        if (mMap == null) {
//            Log.d("MainActivity", "Setting up Bowl Sheet");
//            // Try to obtain the map from the SupportMapFragment.
//            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
//                    .getMap();
//            // Check if we were successful in obtaining the map.
//            if (mMap != null) {
//                setUpMap();
//            }
//        }
//    }
//
//    /**
//     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
//     * just add a marker near Africa.
//     * <p/>
//     * This should only be called once and when we are sure that {@link #mMap} is not null.
//     */
//    private void setUpMap() {
//        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
//    }
//
//    private void handleNewLocation(Location location) {
//        Log.d(TAG, location.toString());
//        Log.d("MainActivity", "Handling new Bowl Sheet");
//
//        double currentLatitude = location.getLatitude();
//        double currentLongitude = location.getLongitude();
//
//        LatLng latLng = new LatLng(currentLatitude, currentLongitude);
//
//        mMap.addMarker(new MarkerOptions().position(new LatLng(currentLatitude, currentLongitude)).title("Current Location"));
//        MarkerOptions options = new MarkerOptions()
//                .position(latLng)
//                .title("I am here!");
//        mMap.addMarker(options);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//    }
//
//    @Override
//    public void onConnected(Bundle bundle) {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            Log.d("MainActivity", "Bowl Sheet");
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
////            return;
//        }
//        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
//        if (location == null) {
//            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
//        }
//        else {
//            handleNewLocation(location);
//        }
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//        /*
//         * Google Play services can resolve some errors it detects.
//         * If the error has a resolution, try sending an Intent to
//         * start a Google Play services activity that can resolve
//         * error.
//         */
//        if (connectionResult.hasResolution()) {
//            try {
//                // Start an Activity that tries to resolve the error
//                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
//                /*
//                 * Thrown if Google Play services canceled the original
//                 * PendingIntent
//                 */
//            } catch (IntentSender.SendIntentException e) {
//                // Log the error
//                e.printStackTrace();
//            }
//        } else {
//            /*
//             * If no resolution is available, display a dialog to the
//             * user with the error.
//             */
//            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
//        }
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//        handleNewLocation(location);
//    }
//
//
////    @Override
////    public void onMapReady(GoogleMap googleMap) {
////        mMap = googleMap;
////
////        // Add a marker in Sydney, Australia, and move the camera.
////        LatLng sf = new LatLng(37.77, 122.41);
////        mMap.addMarker(new MarkerOptions().position(sf).title("Marker in SF"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sf));
////    }
//
//}
//>>>>>>> master
