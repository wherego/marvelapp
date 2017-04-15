package com.eric.airwick.marvel.api.Models;

/**
 * Created by airwick on 15/04/2017.
 */

public final class Characters {
    public final String code;
    public final String status;
    public final String copyright;
    public final String attributionText;
    public final String attributionHTML;
    public final Data data;
    public final String etag;

    public Characters(String code, String status, String copyright, String attributionText, String attributionHTML, Data data, String etag) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.data = data;
        this.etag = etag;
    }

    public static final class Data {
        public final String offset;
        public final String limit;
        public final String total;
        public final String count;
        public final Result results[];

        public Data(String offset, String limit, String total, String count, Result[] results) {
            this.offset = offset;
            this.limit = limit;
            this.total = total;
            this.count = count;
            this.results = results;
        }

        public static final class Result {
            public final String id;
            public final String name;
            public final String description;
            public final String modified;
            public final String resourceURI;
            public final Url urls[];
            public final Thumbnail thumbnail;
            public final Comics comics;
            public final Stories stories;
            public final Events events;
            public final Series series;

            public Result(String id, String name, String description, String modified, String resourceURI, Url[] urls, Thumbnail thumbnail, Comics comics, Stories stories, Events events, Series series) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.modified = modified;
                this.resourceURI = resourceURI;
                this.urls = urls;
                this.thumbnail = thumbnail;
                this.comics = comics;
                this.stories = stories;
                this.events = events;
                this.series = series;
            }

            public static final class Url {
                public final String type;
                public final String url;

                public Url(String type, String url) {
                    this.type = type;
                    this.url = url;
                }
            }

            public static final class Thumbnail {
                public final String path;
                public final String extension;

                public Thumbnail(String path, String extension) {
                    this.path = path;
                    this.extension = extension;
                }
            }

            public static final class Comics {
                public final String available;
                public final String returned;
                public final String collectionURI;
                public final Item items[];

                public Comics(String available, String returned, String collectionURI, Item[] items) {
                    this.available = available;
                    this.returned = returned;
                    this.collectionURI = collectionURI;
                    this.items = items;
                }

                public static final class Item {
                    public final String resourceURI;
                    public final String name;

                    public Item(String resourceURI, String name) {
                        this.resourceURI = resourceURI;
                        this.name = name;
                    }
                }
            }

            public static final class Stories {
                public final String available;
                public final String returned;
                public final String collectionURI;
                public final Item items[];

                public Stories(String available, String returned, String collectionURI, Item[] items) {
                    this.available = available;
                    this.returned = returned;
                    this.collectionURI = collectionURI;
                    this.items = items;
                }

                public static final class Item {
                    public final String resourceURI;
                    public final String name;
                    public final String type;

                    public Item(String resourceURI, String name, String type) {
                        this.resourceURI = resourceURI;
                        this.name = name;
                        this.type = type;
                    }
                }
            }

            public static final class Events {
                public final String available;
                public final String returned;
                public final String collectionURI;
                public final Item items[];

                public Events(String available, String returned, String collectionURI, Item[] items) {
                    this.available = available;
                    this.returned = returned;
                    this.collectionURI = collectionURI;
                    this.items = items;
                }

                public static final class Item {
                    public final String resourceURI;
                    public final String name;

                    public Item(String resourceURI, String name) {
                        this.resourceURI = resourceURI;
                        this.name = name;
                    }
                }
            }

            public static final class Series {
                public final String available;
                public final String returned;
                public final String collectionURI;
                public final Item items[];

                public Series(String available, String returned, String collectionURI, Item[] items) {
                    this.available = available;
                    this.returned = returned;
                    this.collectionURI = collectionURI;
                    this.items = items;
                }

                public static final class Item {
                    public final String resourceURI;
                    public final String name;

                    public Item(String resourceURI, String name) {
                        this.resourceURI = resourceURI;
                        this.name = name;
                    }
                }
            }
        }
    }
}