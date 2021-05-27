import java.util

def maximumUnits(boxTypes: Array[Array[Int]], truckSize: Int) = {
  util.Arrays.sort(boxTypes, (a: Array[Int], b: Array[Int]) => b(1) - a(1))
  var cnt = 0
  var i = 0
  while ( {
    i < boxTypes.length && truckSize > 0
  }) {
    cnt += Math.min(truckSize, boxTypes(i)(0)) * boxTypes(i)(1)
    truckSize -= boxTypes(i)(0)

    i += 1
  }
  cnt
}