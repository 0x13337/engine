package jadx.tests.integration;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.IntegrationTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class TestStaticMethod extends IntegrationTest {

    @Test
    public void test() {
        ClassNode cls = getClassNode(TestCls.class);
        String code = cls.getCode().toString();

        assertThat(code, containsString("static {"));
        assertThat(code, containsString("private static void f() {"));
    }

    public static class TestCls {
        static {
            f();
        }

        private static void f() {
        }
    }
}