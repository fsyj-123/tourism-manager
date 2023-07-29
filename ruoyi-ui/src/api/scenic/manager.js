import request from '@/utils/request'

// 查询景区管理列表
export function listManager(query) {
  return request({
    url: '/scenic/manager/list',
    method: 'get',
    params: query
  })
}

// 查询景区管理详细
export function getManager(id) {
  return request({
    url: '/scenic/manager/' + id,
    method: 'get'
  })
}

// 新增景区管理
export function addManager(data) {
  return request({
    url: '/scenic/manager',
    method: 'post',
    data: data
  })
}

// 修改景区管理
export function updateManager(data) {
  return request({
    url: '/scenic/manager',
    method: 'put',
    data: data
  })
}

// 删除景区管理
export function delManager(id) {
  return request({
    url: '/scenic/manager/' + id,
    method: 'delete'
  })
}
