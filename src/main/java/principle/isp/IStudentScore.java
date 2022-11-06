package principle.isp;

/**
 * 不符合接口隔离原则
 * 可将其拆分为
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @see IQueryScore
 * @see IOperateScore
 * @since 1.8
 */
public interface IStudentScore {
    // 查询成绩
    void queryScore();

    // 修改成绩
    void updateScore();

    // 添加成绩
    void saveScore();

    // 删除成绩
    void delete();

    // 计算总分
    double sum();

    // 计算平均分
    double avg();

    // 打印成绩单
    void printScore();
}
