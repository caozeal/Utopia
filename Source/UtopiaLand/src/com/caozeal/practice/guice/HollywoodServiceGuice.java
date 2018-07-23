package com.caozeal.practice.guice;

import com.caozeal.practice.guice.finder.AgentFinder;
import com.google.inject.Inject;

import java.util.List;

/**
 * <p>创建时间：2018/7/3 13:47
 * <p>com.caozeal.practice.guice
 * @author caozhiyong
 * @version 1.0
 */
public class HollywoodServiceGuice {

    private AgentFinder finder;

    @Inject
    public HollywoodServiceGuice(AgentFinder finder){
        this.finder = finder;
    }

    public List<Agent> getFriendlyAgents(){
        List<Agent> agents = finder.findAllAgents();
        return agents;
    }
}
