var FileSaver = require('file-saver')
export async function exportCsv (data, head, total, title, size, onProcess = () => {}) {
  try {
    // 切片
    var step = total / size
    // CSV 缓存
    const cvsArray = []
    // 截取下标
    var item = 0
    // 创建表头
    cvsArray.push(head.join() + '\n')
    for (let i = 0; i < step; i++) {
      await new Promise((resolve, reject) => {
        try {
          // 格式化为 CSV 字符串
          data.slice(item, item + size).map(row => {
            addCode(row) // 处理csv文件符号
            var str = Object.values(row)
            str = changeKey(str)
            cvsArray.push(str + '\n')
          })
          // 统计进度
          const process = Math.ceil((i / step) * 100)
          onProcess(process)
          item = item + size
          /* 适当暂停防止页面卡盾 */
          setTimeout(() => resolve(true), 500)
        } catch (error) {
          reject(error)
        }
      })
    }
    // 遍历完成时，固定进度为 100%
    onProcess(100)

    const blob = new Blob([String.fromCharCode(0xfeff), ...cvsArray], {
      type: 'text/plain;charset=utf-8'
    })

    await FileSaver.saveAs(blob, `${title}.xlsx`)

    return true
  } catch (error) {
    return Promise.reject(error)
  }
}
/* 处理csv的，分隔符；以及科学计数法问题 */
function addCode (row) {
  for (const key in row) {
    var str = row[key]
    str = '"\t' + str + '"'
    row[key] = str
  }
}

function changeKey (Arr) {
  Arr.splice(0, 0, Arr[Arr.length - 1])
  Arr.pop()
  return Arr
}
