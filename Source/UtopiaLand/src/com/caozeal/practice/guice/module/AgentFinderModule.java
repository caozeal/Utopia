package com.caozeal.practice.guice.module;

import com.caozeal.practice.guice.finder.AgentFinder;
import com.caozeal.practice.guice.finder.WebServiceAgentFinder;
import com.google.inject.AbstractModule;

/**
 * <p>创建时间：2018/7/3 11:22
 * <p>com.caozeal.practice.guice.module
 * @author caozhiyong
 * @version 1.0
 */
public class AgentFinderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AgentFinder.class).to(WebServiceAgentFinder.class);
    }
}
