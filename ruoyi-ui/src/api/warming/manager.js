import request from '@/utils/request'

// 查询告警信息管理列表
export function listManager(query) {
  return request({
    url: '/warming/manager/list',
    method: 'get',
    params: query
  })
}

// 查询告警信息管理详细
export function getManager(warmId) {
  return request({
    url: '/warming/manager/' + warmId,
    method: 'get'
  })
}

// 新增告警信息管理
export function addManager(data) {
  return request({
    url: '/warming/manager',
    method: 'post',
    data: data
  })
}

// 修改告警信息管理
export function updateManager(data) {
  return request({
    url: '/warming/manager',
    method: 'put',
    data: data
  })
}

// 删除告警信息管理
export function delManager(warmId) {
  return request({
    url: '/warming/manager/' + warmId,
    method: 'delete'
  })
}
