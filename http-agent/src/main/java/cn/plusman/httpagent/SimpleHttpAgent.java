package cn.plusman.httpagent;

import cn.plusman.httpagent.example.MyInstrumentationAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * cn.plusman.httpagent.example
 *
 * @author plusman
 * @since 1/2/21
 */
public class SimpleHttpAgent {
    private static Logger LOGGER = LoggerFactory.getLogger(SimpleHttpAgent.class);

    /**
     * 为什么不定义一个接口在此处实现呢，因为静态方法无法继承或实现
     * @param agentArgs
     * @param ins
     */
    public static void premain(String agentArgs, Instrumentation ins) {
        LOGGER.info("[SimpleHttpAgent] In premain method");
        ins.addTransformer(new HttpTransformer(), true);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        LOGGER.info("[SimpleHttpAgent] In agentmain method");
    }
}
