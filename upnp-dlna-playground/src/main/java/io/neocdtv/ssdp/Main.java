/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.neocdtv.ssdp;

/**
 *
 * @author xix
 */
public class Main {
  public static void main(String[] args) throws InterruptedException {
    new SsdpNotify().start();
    new SsdpResponseToDiscover().start();
    //new SsdpResponseToDiscover().start();
  }
}
