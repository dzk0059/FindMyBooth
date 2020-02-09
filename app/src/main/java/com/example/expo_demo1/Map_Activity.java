package com.example.expo_demo1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.lang.NullPointerException;

//For Button2
public class Map_Activity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    private Marker mMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        //set zoom level to 15 so that we can see Auburn univ as a default setting
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(32.602654, -85.484795), 15));

        //Marker for Auburn University
        LatLng Auburn_University = new LatLng(32.593547, -85.495080);
        map.moveCamera(CameraUpdateFactory.newLatLng(Auburn_University));
        setCamera(Auburn_University,15,"Auburn University",1);

        //Marker for Career center
        LatLng Career_fair = new LatLng(32.600331, -85.492433);
        map.moveCamera(CameraUpdateFactory.newLatLng(Career_fair));
        setCamera(Career_fair,15,"Beard-Eaves Collseum",2);

        //Marker for Student Center
        LatLng Student_Center = new LatLng(32.602695, -85.486444);
        map.moveCamera(CameraUpdateFactory.newLatLng(Student_Center));
        setCamera(Student_Center,15,"Student Center",3);

        //Marker for Broun_Kopel
        LatLng Broun_Kopel = new LatLng(32.605696, -85.484748);
        map.moveCamera(CameraUpdateFactory.newLatLng(Broun_Kopel));
        setCamera(Broun_Kopel,15,"Brown-Kopel",4);

        //Marker for AU_Arena
        LatLng AU_Arena = new LatLng(32.603290, -85.491811);
        map.moveCamera(CameraUpdateFactory.newLatLng(AU_Arena));
        setCamera(AU_Arena,15,"AU_Arena",5);

    }
    private void setCamera(LatLng latlng, float zoom, String building_name,int building_num){

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,zoom));

        String info = "";

        //title session


        //info session
        String building1 = "Auburn University";
        String building2 = "Engineering & Technology Career Fair on 2/10 at 2P.M to 6P.M";
        String building3 = "Student Center";
        String building4 = "Auburn University Career Fair on 3/24 at 2P.M to 6P.M";
        String building5 = "AU Arena";
        try {
            switch (building_num) {
                case 1:
                    info = building1;

                    break;
                case 2:
                    info = building2;

                    break;
                case 3:
                    info = building3;

                    break;
                case 4:
                    info = building4;
                    break;

                case 5:
                    info = building5;

                    break;
            }
        }
        catch(NullPointerException e){

            System.out.print("Nothing can show");
        }
        MarkerOptions options = new MarkerOptions()
                .position(latlng)
                .title(building_name)
                .snippet(info);
        mMarker = map.addMarker(options);

    }

}

