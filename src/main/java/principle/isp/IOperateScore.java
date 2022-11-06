package principle.isp;

/**
 * 只负责对分数进行处理
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since
 */
public interface IOperateScore {
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
}
