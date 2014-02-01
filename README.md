yandex-maps-static-api
======================

Library for working with [Yandex Maps Static API 1.x](http://api.yandex.ru/maps/doc/staticapi/)

Done
----

Currently, yandex-maps-static-api supports only basic features:
- Support for [map types](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_type.xml)
- Support for setting a [map center](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_center.xml)

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
- Add support for basic map properties ([viewport](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_viewport.xml), [scale](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/map_scale.xml), [localization](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/localization.xml), [API key](http://api.yandex.ru/maps/form.xml))
- Add support for [Markers](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/markers.xml)
- Add support for [Polylines](http://api.yandex.ru/maps/doc/staticapi/1.x/dg/concepts/polylines.xml)
