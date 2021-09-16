package com.dogigiri.core.network.ipaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            System.out.println(getHostIpByHostName("www.amazon.com"));
            System.out.println(getHostNameByIp("2.21.141.129"));
            for (InetAddress address : getAllAddressesByHostName("www.amazon.com")) {
                System.out.println(address);
            }
            System.out.println(getMyAddress());
            System.out.println(getAddressByIp(new byte[]{23, 53, (byte)169, 61}).getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static String getHostIpByHostName(String url) throws UnknownHostException {
        return InetAddress.getByName(url).toString();
    }

    private static String getHostNameByIp(String ip) throws UnknownHostException{
        return InetAddress.getByName(ip).getHostName();
    }

    private static InetAddress[] getAllAddressesByHostName(String url) throws UnknownHostException {
        return InetAddress.getAllByName("www.amazon.com");
    }

    private static String getMyAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().toString();
    }

    private static InetAddress getAddressByIp(byte[] ip) throws UnknownHostException {
        return InetAddress.getByAddress(ip);
    }
}
