/*
 * Copyright 2013 SatoShun
 *
 * Proxy Pattern
 */

package sample.design_pattern;


interface IHttpAccessor {
    String access(String url);
}


class HttpAccessor implements IHttpAccessor {
    /*
     * return response data ...
     */
    public String access(String url) {
        return "access : " + url;
    }
}


class HttpProxyAccessor implements IHttpAccessor {
    private HttpAccessor accessor;

    /*
     * delegate HttpAccessor
     */
    public String access(String url) {
        if (accessor == null) {
            accessor = new HttpAccessor();
        }
        return accessor.access(url);
    }
}


class Proxy {
    public static void main(String[] args) {
        HttpProxyAccessor accessor = new HttpProxyAccessor();
        System.out.println(accessor.access("http://hogehoge"));
    }
}
