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

Usage
-----
```Java
// Firstly, you need to create YandexMap object
YandexMap yandexMap = new YandexMap();
// Init required fields

// ...

// Use YandexApiUrlBuilder to generate appropriate URL for using in a browser or web component
String url = YandexApiUrlBuilder.build(yandexMap);
```
Further plans
-----
- Support for [localization](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/localization.xml)
- Support for [Markers](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml)
- Support for [Polylines](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml)
- Support for [Geocoding](http://api.yandex.ru/maps/doc/geocoder/desc/concepts/About.xml)
