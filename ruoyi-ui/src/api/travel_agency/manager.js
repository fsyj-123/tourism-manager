import request from '@/utils/request'

// 查询旅行社基础信息列表
export function listManager(query) {
  return request({
    url: '/travel_agency/manager/list',
    method: 'get',
    params: query
  })
}

// 查询旅行社基础信息详细
export function getManager(id) {
  return request({
    url: '/travel_agency/manager/' + id,
    method: 'get'
  })
}

// 新增旅行社基础信息
export function addManager(data) {
  return request({
    url: '/travel_agency/manager',
    method: 'post',
    data: data
  })
}

// 修改旅行社基础信息
export function updateManager(data) {
  return request({
    url: '/travel_agency/manager',
    method: 'put',
    data: data
  })
}

// 删除旅行社基础信息
export function delManager(id) {
  return request({
    url: '/travel_agency/manager/' + id,
    method: 'delete'
  })
}
