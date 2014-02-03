yandex-maps-static-api
======================

Library for working with [Yandex Maps Static API 1.x](http://api.yandex.ru/maps/doc/staticapi/)

Done
----
- Support for basic map properties
  - [map types](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_type.xml)
  - [map center](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_center.xml)
  - [viewport](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_viewport.xml)
  - [scale](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_scale.xml)
  - [API key](http://api.yandex.ru/maps/form.xml)
  - [localization](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/localization.xml)
- Basic support for [Polylines](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml)
  - Curves

Usage
-----
```Java

// Firstly, you need to create YandexMap object
YandexMap yandexMap = new YandexMap();

// Init required fields
yandexMap.setMapType(YandexMap.MapType.HYBRID);
yandexMap.setCenter(new Coordinate(37.65675f,55.74142f));
yandexMap.setViewport(new Coordinate(0.1, 0.1);
yandexMap.setScale(7);
yandexMap.setSize(new Size(500, 500));
yandexMap.setLanguage(YandexMap.Language.RUSSIAN);

// Add curve (you can add multiple curves if necessary)
Curve curve = new Curve();
curve.setColor(Color.BLACK);
curve.addPoint(new Coordinate(37.656577f, 55.741176f));
curve.addPoint(new Coordinate(37.656748f, 55.741419f));
curve.addPoint(new Coordinate(37.655131f, 55.741814f));
curve.addPoint(new Coordinate(37.658257f, 55.742524f));
yandexMap.addPolyline(curve);

// Use YandexApiUrlBuilder to generate appropriate URL for using in a browser or web component
String url = YandexApiUrlBuilder.build(yandexMap);
```
Further plans
-----
- Support for [Polylines](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml)
  - Polygons
  - Base64 coordinates encoding
- Support for [Markers](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml)
- Support for [Geocoding](http://api.yandex.ru/maps/doc/geocoder/desc/concepts/About.xml)
