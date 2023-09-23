package com.ultims.productmgt.queryservice.product.route.v1;

public abstract class ProductRoute {

    private ProductRoute() {
    }

    private static final String RESSOURCE = "products";
    private static final String VERSION = "v1";
    private static final String BASE_URL = "api" + "/" + VERSION + "/" + RESSOURCE;
    private static final String ID = "{id}";

    public static final String GET_ALL = BASE_URL;
    public static final String GET_BY_ID = BASE_URL + "/" + ID;
}
