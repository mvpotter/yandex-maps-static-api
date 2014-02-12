yandex-maps-static-api
======================

Library for working with [Yandex Maps Static API 1.x](http://api.yandex.ru/maps/doc/staticapi/)

Done
----
- Support for map properties
  - [map types](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_type.xml)
  - [map center](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_center.xml)
  - [viewport](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_viewport.xml)
  - [scale](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_scale.xml)
  - [API key](http://api.yandex.ru/maps/form.xml)
  - [localization](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/localization.xml)
- Support for [Polylines](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml)
  - Curves
  - Polygons
  - Coordinates encoding
- Support for [Markers](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml)

Usage
-----
```Java
// Firstly, you need to create YandexMap object
YandexMap yandexMap = new YandexMap();

// Init required fields
yandexMap.setMapType(YandexMap.MapType.HYBRID);
yandexMap.setCenter(new Coordinate("37.660286", "55.743301"));
yandexMap.setViewport(new Coordinate("0.005", "0.005"));
yandexMap.setScale(7);
yandexMap.setSize(new Size(650, 450));
yandexMap.setLanguage(YandexMap.Language.RUSSIAN);

// Add curve (you can add multiple curves if necessary)
Curve curve = new Curve();
curve.setColor(Color.BLACK);
curve.addPoint(new Coordinate("37.656577", "55.741176"));
curve.addPoint(new Coordinate("37.656748", "55.741419"));
curve.addPoint(new Coordinate("37.655131", "55.741814"));
curve.addPoint(new Coordinate("37.658257", "55.742524"));
yandexMap.addPolyline(curve);

// Add polygon (multiple if necessary)
Polygon polygon = new Polygon();
polygon.setColor(Color.WHITE);

// Add outer line (the enclosed area will be filled with color)
Curve outerCurve = new Curve();
outerCurve.addPoint(new Coordinate("0", "0"));
outerCurve.addPoint(new Coordinate("0", "4"));
outerCurve.addPoint(new Coordinate("4", "4"));
outerCurve.addPoint(new Coordinate("4", "0"));
polygon.addCurve(outerCurve);

// Add inner line (the enclosed area will not be filled)
Curve innerCurve = new Curve();
innerCurve.addPoint(new Coordinate("1", "1"));
innerCurve.addPoint(new Coordinate("1", "3"));
innerCurve.addPoint(new Coordinate("3", "3"));
innerCurve.addPoint(new Coordinate("3", "1"));
polygon.addCurve(innerCurve);

yandexMap.addPolyline(polygon);

// Add markers
yandexMap.addMarker(new Marker(new Coordinate("37.656577", "55.741176")));
yandexMap.addMarker(new Marker(new Coordinate("37.656748", "55.741419"), Style.FLAG));
yandexMap.addMarker(new Marker(new Coordinate("37.655131", "55.741814"), Style.PIN, Type.BLACK));
yandexMap.addMarker(new Marker(new Coordinate("37.658257", "55.742524"), Style.PIN, Type.GRAY));
yandexMap.addMarker(new Marker(new Coordinate("37.660286", "55.743301"), Style.SQUARE, Type.A));
yandexMap.addMarker(new Marker(new Coordinate("37.661831", "55.745165"), Style.SQUARE, Type.B));
yandexMap.addMarker(new Marker(new Coordinate("37.662947", "55.743108"), Style.ROUND, Type.B));

// Use YandexApiUrlBuilder to generate appropriate URL for using in a browser or web component
YandexApiUrlBuilder yandexApiUrlBuilder = new YandexApiUrlBuilder();
String url = yandexApiUrlBuilder.build(yandexMap);
```

