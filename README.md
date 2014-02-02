yandex-maps-static-api
======================

Library for working with [Yandex Maps Static API 1.x](http://api.yandex.ru/maps/doc/staticapi/)

Done
----
Currently, yandex-maps-static-api supports only basic features:
- Support for basic map properties
  - [map types](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_type.xml)
  - [map center](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_center.xml)
  - [viewport](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_viewport.xml)
  - [scale](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_scale.xml)
  - [API key](http://api.yandex.ru/maps/form.xml)
  - [localization](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/localization.xml)

Usage
-----
```Java

// Firstly, you need to create YandexMap object
YandexMap yandexMap = new YandexMap();

// Init required fields
yandexMap.setMapType(YandexMap.MapType.HYBRID);
yandexMap.setCenter(new Coordinate(83.098206f, 54.851702f));
yandexMap.setViewport(new Coordinate(0.1, 0.1);
yandexMap.setScale(7);
yandexMap.setSize(new Size(500, 500));
yandexMap.setLanguage(YandexMap.Language.RUSSIAN);

// Use YandexApiUrlBuilder to generate appropriate URL for using in a browser or web component
String url = YandexApiUrlBuilder.build(yandexMap);
```
Further plans
-----
- Support for [Markers](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml)
- Support for [Polylines](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml)
- Support for [Geocoding](http://api.yandex.ru/maps/doc/geocoder/desc/concepts/About.xml)
