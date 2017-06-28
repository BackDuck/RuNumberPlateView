# RuNumberPlateView - Russian numbers plate view

<img src="http://pitsmap.ru/test/plates/screen.png" width="300"> 

Just add this code in you layout
```
<com.example.nurshat.runumberplateview.NumberPlate
        android:id="@+id/numberPlateView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:use_hint="true"
        app:template="@integer/TAXI_CAR_PLATE"/>
```
        

Available templates for plates:

View | Value
-----|------
<img src="http://pitsmap.ru/test/plates/plate1.jpg" width="250"> | CIVIL_CAR_PLATE
<img src="http://pitsmap.ru/test/plates/plate2.jpg" width="250"> | TAXI_CAR_PLATE
<img src="http://pitsmap.ru/test/plates/plate3.jpg" width="250"> | MILITARY_CAR_PLATE
<img src="http://pitsmap.ru/test/plates/plate4.jpg" width="250"> | DIPLOMATIC_CAR_PLATE
<img src="http://pitsmap.ru/test/plates/plate5.jpg" width="250"> | POLICE_CAR_PLATE
<img src="http://pitsmap.ru/test/plates/plate6.jpg" width="250"> | TRANSIT_CAR_PLATE

You can hide hint(placeholder), for this use

```app:use_hint="false"```

For get result from plate you can use next methods:
 ``` 
 NumberPlate np = (NumberPlate) findViewById(R.id.numberPlateView);
      np.getFullNumber(); // get full number (А777АА116)
      np.getNumber(); // get number only (A777AA)
      np.getRegion(); // get region only (116)
      np.toString(); // get full number (А777АА116)
```
