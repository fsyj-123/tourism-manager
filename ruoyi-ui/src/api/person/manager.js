import request from '@/utils/request'

// 查询人员管理列表
export function listManager(query) {
  return request({
    url: '/person/manager/list',
    method: 'get',
    params: query
  })
}

// 查询人员管理详细
export function getManager(personId) {
  return request({
    url: '/person/manager/' + personId,
    method: 'get'
  })
}

// 新增人员管理
export function addManager(data) {
  return request({
    url: '/person/manager',
    method: 'post',
    data: data
  })
}

// 修改人员管理
export function updateManager(data) {
  return request({
    url: '/person/manager',
    method: 'put',
    data: data
  })
}

// 删除人员管理
export function delManager(personId) {
  return request({
    url: '/person/manager/' + personId,
    method: 'delete'
  })
}
export function getInstitution(institutionType) {
  return request({
    url: '/person/manager/institution/' + institutionType,
    method: 'get'
  })
}
