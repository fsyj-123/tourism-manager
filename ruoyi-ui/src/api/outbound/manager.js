import request from '@/utils/request'

// 查询出境管理列表
export function listManager(query) {
  return request({
    url: '/outbound/manager/list',
    method: 'get',
    params: query
  })
}

// 查询出境管理详细
export function getManager(id) {
  return request({
    url: '/outbound/manager/' + id,
    method: 'get'
  })
}

// 新增出境管理
export function addManager(data) {
  return request({
    url: '/outbound/manager',
    method: 'post',
    data: data
  })
}

// 修改出境管理
export function updateManager(data) {
  return request({
    url: '/outbound/manager',
    method: 'put',
    data: data
  })
}

// 删除出境管理
export function delManager(id) {
  return request({
    url: '/outbound/manager/' + id,
    method: 'delete'
  })
}
