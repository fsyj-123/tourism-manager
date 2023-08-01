import request from '@/utils/request'

// 查询出境管理列表
export function listAudit(query) {
  return request({
    url: '/outbound_travel_audit/audit/list',
    method: 'get',
    params: query
  })
}

// 查询出境管理详细
export function getAudit(id) {
  return request({
    url: '/outbound_travel_audit/audit/' + id,
    method: 'get'
  })
}

// 新增出境管理
export function addAudit(data) {
  return request({
    url: '/outbound_travel_audit/audit',
    method: 'post',
    data: data
  })
}

// 修改出境管理
export function updateAudit(data) {
  return request({
    url: '/outbound_travel_audit/audit',
    method: 'put',
    data: data
  })
}

// 删除出境管理
export function delAudit(id) {
  return request({
    url: '/outbound_travel_audit/audit/' + id,
    method: 'delete'
  })
}
