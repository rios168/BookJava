package com.book.management.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.Date;
import java.util.Random;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {
    public static Random random = getRandom();

    public static Random getRandom() {
        if (random == null) random = new Random((new Date()).getTime());
        return random;
    }

    public static void log(String str) {
        log.debug("-------:" + str);
    }

    private static long timeStart = 0;

    public static void testTimeStart() {
        timeStart = System.currentTimeMillis();
    }

    public static String testTimeEnd() {
        long time = System.currentTimeMillis() - timeStart;
        String str = "消耗毫秒:" + time;
        log(str);
        return str;
    }

    public static boolean equals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        int length;
        if (a != null && b != null && (length = a.length()) == b.length()) {
            if (a instanceof String && b instanceof String) {
                return a.equals(b);
            } else {
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) return false;
                }
                return true;
            }
        }
        return false;
    }


    public static int parseInt(String str) {
        if (str == null) return 0;
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {

        }
        return 0;
    }

    public static long parseLong(String str) {
        if (str == null) return 0;
        try {
            return Long.parseLong(str);
        } catch (Exception e) {

        }
        return 0;
    }

    public static SSLContext createSSLContext() throws Exception {
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("www.roader.vip.pfx");
        InputStream ksInputStream = resources[0].getInputStream();
        String password = "tC0M1Atr";
        KeyStore ks = KeyStore.getInstance("PKCS12"); /// "JKS"
//        InputStream ksInputStream = new FileInputStream(new File("").getAbsolutePath()
//                + "/BOOT-INF/classes/www.roader.vip.pfx"); /// 证书存放地址
        ks.load(ksInputStream, password.toCharArray());
        //KeyManagerFactory充当基于密钥内容源的密钥管理器的工厂。
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());//getDefaultAlgorithm:获取默认的 KeyManagerFactory 算法名称。
        kmf.init(ks, password.toCharArray());
        //SSLContext的实例表示安全套接字协议的实现，它充当用于安全套接字工厂或 SSLEngine 的工厂。
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);
        ksInputStream.close();
        return sslContext;
    }

    public static Long getUserId(HttpServletRequest request) {
        if (request != null && request.getSession() != null && request.getSession().getAttribute("userId") != null) {
            return (Long) request.getSession().getAttribute("userId");
        } else {
            return 0L;
        }
    }

    public static String getToken(HttpServletRequest request) {
        if (request != null && request.getSession() != null && request.getSession().getAttribute("token") != null) {
            return (String) request.getSession().getAttribute("token");
        } else {
            return null;
        }
    }

    public static boolean isEmpty(String photos) {
        return photos == null || photos.equals("");
    }
}
