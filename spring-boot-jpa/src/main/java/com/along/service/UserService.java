package com.along.service;

import com.along.model.dto.UserDTO;
import com.along.model.entity.User;
import com.along.model.vo.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author along
 * @Date 2019/1/9 14:18
 */
public interface UserService {

    User save(UserDTO user);

    List<User> saveAll(List<UserDTO> list);

    Page<User> findAll(Pageable pageable);

    List<User> findByNameAndSex(String name, Integer sex);

    List<UserVo> findByNameLike(String name);

    List<User> findByName(String name);

    Boolean update(UserDTO user);

    void delete(String id);

    public List<User> findUserByNameAndSex0(String name, Integer sex);

    List<User> findUserByName(String name);

    List<User> findUserByNameAndSex1(String name, Integer sex);

    List<User> findUserByNameAndSex2(String name, Integer sex);

    List<User> findUserByIds(List<String> ids);

    Page<User> findUser(User user, int page, int size);

    List<User> findUserByArticleAndRole(String articleId, String roleId);


}
