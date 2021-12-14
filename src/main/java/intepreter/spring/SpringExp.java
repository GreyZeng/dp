package intepreter.spring;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since 1.8
 */
public class SpringExp {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("200*2 + 100*3+10");
        Integer value = (Integer) expression.getValue();
        System.out.println(value);

    }
}
