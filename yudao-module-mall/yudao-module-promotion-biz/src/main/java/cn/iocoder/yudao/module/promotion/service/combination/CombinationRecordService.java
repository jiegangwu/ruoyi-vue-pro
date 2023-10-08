package cn.iocoder.yudao.module.promotion.service.combination;

import cn.iocoder.yudao.framework.common.core.KeyValue;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.api.combination.dto.CombinationRecordCreateReqDTO;
import cn.iocoder.yudao.module.promotion.api.combination.dto.CombinationValidateJoinRespDTO;
import cn.iocoder.yudao.module.promotion.controller.admin.combination.vo.recrod.CombinationRecordReqPageVO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.combination.CombinationActivityDO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.combination.CombinationProductDO;
import cn.iocoder.yudao.module.promotion.dal.dataobject.combination.CombinationRecordDO;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 拼团记录 Service 接口
 *
 * @author HUIHUI
 */
public interface CombinationRecordService {

    /**
     * 更新拼团状态
     *
     * @param status  状态
     * @param userId  用户编号
     * @param orderId 订单编号
     */
    void updateCombinationRecordStatusByUserIdAndOrderId(Integer status, Long userId, Long orderId);

    /**
     * 【下单前】校验是否满足拼团活动条件
     *
     * 如果校验失败，则抛出业务异常
     *
     * @param userId     用户编号
     * @param activityId 活动编号
     * @param headId     团长编号
     * @param skuId      sku 编号
     * @param count      数量
     * @return 拼团信息
     */
    KeyValue<CombinationActivityDO, CombinationProductDO> validateCombinationRecord(Long userId, Long activityId, Long headId,
                                                                                    Long skuId, Integer count);

    /**
     * 创建拼团记录
     *
     * @param reqDTO 创建信息
     */
    void createCombinationRecord(CombinationRecordCreateReqDTO reqDTO);

    /**
     * 获得拼团记录
     *
     * @param userId  用户编号
     * @param orderId 订单编号
     * @return 拼团记录
     */
    CombinationRecordDO getCombinationRecord(Long userId, Long orderId);

    /**
     * 获取拼团记录
     *
     * @param userId     用户 id
     * @param activityId 活动 id
     * @return 拼团记录列表
     */
    List<CombinationRecordDO> getCombinationRecordListByUserIdAndActivityId(Long userId, Long activityId);

    /**
     * 【下单前】校验是否满足拼团活动条件
     *
     * 如果校验失败，则抛出业务异常
     *
     * @param userId     用户编号
     * @param activityId 活动编号
     * @param headId     团长编号
     * @param skuId      sku 编号
     * @param count      数量
     * @return 拼团信息
     */
    CombinationValidateJoinRespDTO validateJoinCombination(Long userId, Long activityId, Long headId, Long skuId, Integer count);

    /**
     * 获取拼团记录数
     *
     * @param status 状态-允许为空
     * @param virtualGroup 是否虚拟成团-允许为空
     * @return 记录数
     */
    Long getCombinationRecordCount(@Nullable Integer status, @Nullable Boolean virtualGroup);

    /**
     * 获取最近的 count 条拼团记录
     *
     * @param count 限制数量
     * @return 拼团记录列表
     */
    List<CombinationRecordDO> getLatestCombinationRecordList(int count);

    /**
     * 获得最近 n 条拼团记录（团长发起的）
     *
     * @param activityId 拼团活动编号
     * @param status     状态
     * @param count      数量
     * @return 拼团记录列表
     */
    List<CombinationRecordDO> getHeadCombinationRecordList(Long activityId, Integer status, Integer count);

    /**
     * 获取指定编号的拼团记录
     *
     * @param id 拼团记录编号
     * @return 拼团记录
     */
    CombinationRecordDO getCombinationRecordById(Long id);

    /**
     * 获取指定团长编号的拼团记录
     *
     * @param headId 团长编号
     * @return 拼团记录列表
     */
    List<CombinationRecordDO> getCombinationRecordListByHeadId(Long headId);

    /**
     * 获取拼团记录分页数据
     *
     * @param pageVO 分页请求
     * @return 拼团记录分页数据
     */
    PageResult<CombinationRecordDO> getCombinationRecordPage(CombinationRecordReqPageVO pageVO);

    /**
     * 【拼团活动】获得拼团记录数量 Map
     *
     * @param activityIds 活动记录编号数组
     * @param status      拼团状态，允许空
     * @param headId      团长编号，允许空。目的 headId 设置为 {@link CombinationRecordDO#HEAD_ID_GROUP} 时，可以设置
     * @return 拼团记录数量 Map
     */
    Map<Long, Integer> getCombinationRecordCountMapByActivity(Collection<Long> activityIds,
                                                              @Nullable Integer status,
                                                              @Nullable Long headId);


    /**
     * 获取拼团记录
     *
     * @param userId 用户编号
     * @param id     拼团记录编号
     * @return 拼团记录
     */
    CombinationRecordDO getCombinationRecordByIdAndUser(Long userId, Long id);

    /**
     * 取消拼团
     *
     * @param userId 用户编号
     * @param id     拼团记录编号
     * @param headId 团长编号
     */
    void cancelCombinationRecord(Long userId, Long id, Long headId);


}
