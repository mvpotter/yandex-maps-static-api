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

Polygon polygon = new Polygon();
polygon.setColor(Color.WHITE);
polygon.addPoint(new Coordinate("37.660286", "55.743301"));
polygon.addPoint(new Coordinate("37.661831", "55.745165"));
polygon.addPoint(new Coordinate("37.662947", "55.743108"));
polygon.addPoint(new Coordinate("37.660286", "55.743301"));
yandexMap.addPolyline(polygon);

// Use YandexApiUrlBuilder to generate appropriate URL for using in a browser or web component
String url = YandexApiUrlBuilder.build(yandexMap);
```
Further plans
-----
- Support for [Markers](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml)
- Support for [Geocoding](http://api.yandex.ru/maps/doc/geocoder/desc/concepts/About.xml)
