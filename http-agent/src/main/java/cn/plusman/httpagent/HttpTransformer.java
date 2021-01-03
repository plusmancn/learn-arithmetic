package cn.plusman.httpagent;

import javassist.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;

/**
 * cn.plusman.httpagent
 *
 * @author plusman
 * @since 1/2/21
 */
public class HttpTransformer implements ClassFileTransformer {
    private static Logger LOGGER = LoggerFactory.getLogger(HttpTransformer.class);

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.equals(CONSTANTS.HACK_CLASS)) {
            String finalTargetClassName = CONSTANTS.HACK_CLASS.replaceAll("\\/", ".");

            LOGGER.info("Find {}" , CONSTANTS.HACK_CLASS);

            try {
                ClassPool cp = ClassPool.getDefault();
                CtClass cc = cp.get(finalTargetClassName);
                CtMethod method = cc.getDeclaredMethod(CONSTANTS.HACK_METHOD);

                // 头部嵌入
                method.addLocalVariable("startTime", CtClass.longType);
                method.insertBefore("startTime = System.currentTimeMillis();");

                // 尾部嵌入代码
                StringBuilder endBlock = new StringBuilder();
                method.addLocalVariable("endTime", CtClass.longType);
                method.addLocalVariable("opTime", CtClass.longType);
                endBlock.append("endTime = System.currentTimeMillis();");
                endBlock.append("opTime = endTime-startTime;");
                endBlock.append("System.out.println(\"HttpRequest finished in \" + opTime + \"ms\");");
                method.insertAfter(endBlock.toString());

                // 重新挂载类
                cc.detach();
                return cc.toBytecode();
            } catch (NotFoundException | CannotCompileException | IOException e) {
                LOGGER.error("Transform {} fail", CONSTANTS.HACK_CLASS, e);
            }
        }

        return null;
    }
}
