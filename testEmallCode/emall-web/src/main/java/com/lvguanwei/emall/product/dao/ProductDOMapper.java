package com.lvguanwei.emall.product.dao;

import com.lvguanwei.emall.product.dao.model.ProductDO;
import com.lvguanwei.emall.product.dao.model.ProductDOExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProductDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @SelectProvider(type=ProductDOSqlProvider.class, method="countByExample")
    int countByExample(ProductDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @DeleteProvider(type=ProductDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @Delete({
        "delete from product",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @Insert({
        "insert into product (id, name, ",
        "price, location, ",
        "city, province, ",
        "is_physical_store, store_name, ",
        "store_location, is_delivery_door, ",
        "is_used_goods, is_changed_eachother, ",
        "is_hot, popularity_index, ",
        "status, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=BIGINT}, #{location,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{isPhysicalStore,jdbcType=BIT}, #{storeName,jdbcType=VARCHAR}, ",
        "#{storeLocation,jdbcType=VARCHAR}, #{isDeliveryDoor,jdbcType=BIT}, ",
        "#{isUsedGoods,jdbcType=BIT}, #{isChangedEachother,jdbcType=BIT}, ",
        "#{isHot,jdbcType=BIT}, #{popularityIndex,jdbcType=BIGINT}, ",
        "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(ProductDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @InsertProvider(type=ProductDOSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(ProductDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @SelectProvider(type=ProductDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.BIGINT),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_physical_store", property="isPhysicalStore", jdbcType=JdbcType.BIT),
        @Result(column="store_name", property="storeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_location", property="storeLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_delivery_door", property="isDeliveryDoor", jdbcType=JdbcType.BIT),
        @Result(column="is_used_goods", property="isUsedGoods", jdbcType=JdbcType.BIT),
        @Result(column="is_changed_eachother", property="isChangedEachother", jdbcType=JdbcType.BIT),
        @Result(column="is_hot", property="isHot", jdbcType=JdbcType.BIT),
        @Result(column="popularity_index", property="popularityIndex", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ProductDO> selectByExample(ProductDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @Select({
        "select",
        "id, name, price, location, city, province, is_physical_store, store_name, store_location, ",
        "is_delivery_door, is_used_goods, is_changed_eachother, is_hot, popularity_index, ",
        "status, create_time, update_time",
        "from product",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.BIGINT),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_physical_store", property="isPhysicalStore", jdbcType=JdbcType.BIT),
        @Result(column="store_name", property="storeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_location", property="storeLocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_delivery_door", property="isDeliveryDoor", jdbcType=JdbcType.BIT),
        @Result(column="is_used_goods", property="isUsedGoods", jdbcType=JdbcType.BIT),
        @Result(column="is_changed_eachother", property="isChangedEachother", jdbcType=JdbcType.BIT),
        @Result(column="is_hot", property="isHot", jdbcType=JdbcType.BIT),
        @Result(column="popularity_index", property="popularityIndex", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ProductDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @UpdateProvider(type=ProductDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductDO record, @Param("example") ProductDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @UpdateProvider(type=ProductDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductDO record, @Param("example") ProductDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @UpdateProvider(type=ProductDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbggenerated Tue Aug 25 18:54:18 CST 2015
     */
    @Update({
        "update product",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=BIGINT},",
          "location = #{location,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "is_physical_store = #{isPhysicalStore,jdbcType=BIT},",
          "store_name = #{storeName,jdbcType=VARCHAR},",
          "store_location = #{storeLocation,jdbcType=VARCHAR},",
          "is_delivery_door = #{isDeliveryDoor,jdbcType=BIT},",
          "is_used_goods = #{isUsedGoods,jdbcType=BIT},",
          "is_changed_eachother = #{isChangedEachother,jdbcType=BIT},",
          "is_hot = #{isHot,jdbcType=BIT},",
          "popularity_index = #{popularityIndex,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProductDO record);
}