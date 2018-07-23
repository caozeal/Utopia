package com.caozeal.practice.guice;

import com.caozeal.practice.guice.module.AgentFinderModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

/**
 * <p>创建时间：2018/7/3 11:18
 * <p>com.caozeal.practice.guice
 * @author caozhiyong
 * @version 1.0
 */
public class HollywoodServiceClient {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AgentFinderModule());
        HollywoodServiceGuice hollywoodService = injector.getInstance(HollywoodServiceGuice.class);
        List<Agent> agents = hollywoodService.getFriendlyAgents();
    }
}
