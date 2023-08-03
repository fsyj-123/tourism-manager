import request from '@/utils/request'

// 查询签证管理列表
export function listManager(query) {
  return request({
    url: '/visa/manager/list',
    method: 'get',
    params: query
  })
}

// 查询签证管理详细
export function getManager(visaId) {
  return request({
    url: '/visa/manager/' + visaId,
    method: 'get'
  })
}

// 新增签证管理
export function addManager(data) {
  return request({
    url: '/visa/manager',
    method: 'post',
    data: data
  })
}

// 修改签证管理
export function updateManager(data) {
  return request({
    url: '/visa/manager',
    method: 'put',
    data: data
  })
}

// 删除签证管理
export function delManager(visaId) {
  return request({
    url: '/visa/manager/' + visaId,
    method: 'delete'
  })
}
