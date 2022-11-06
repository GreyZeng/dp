package principle.isp;

/**
 * 只负责查询
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public interface IQueryScore {
    // 查询成绩
    void queryScore();

    // 打印成绩单
    void printScore();
}
