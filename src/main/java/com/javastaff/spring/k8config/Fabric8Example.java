package com.javastaff.spring.k8config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.DoneableConfigMap;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.Resource;
/**
 * Example read ConfigMap using Fabric8 library
 *
 */
public class Fabric8Example {
  private static final Logger logger = LoggerFactory.getLogger(Fabric8Example.class);

  public static void main(String[] args) throws InterruptedException {
    Config config = new ConfigBuilder().build();
    KubernetesClient client = new DefaultKubernetesClient(config);
    String namespace = "default";
    String name = "test";
    try {
      Resource<ConfigMap, DoneableConfigMap> configMapResource = 
    		  client.configMaps().inNamespace(namespace).withName(name);
      ConfigMap configMap=configMapResource.get();
      logger.info(configMap.getData().toString());
    } finally {
      client.close();
    }
  }
}
